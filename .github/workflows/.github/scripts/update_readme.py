import requests
import datetime

README_PATH = "README.md"
START_TAG = "<!-- LEETCODE_DAILY_START -->"
END_TAG = "<!-- LEETCODE_DAILY_END -->"

def fetch_daily_challenge():
    query = """
    query questionOfToday {
      activeDailyCodingChallengeQuestion {
        date
        link
        question {
          title
          titleSlug
        }
      }
    }
    """

    response = requests.post("https://leetcode.com/graphql", json={"query": query})
    data = response.json()["data"]["activeDailyCodingChallengeQuestion"]

    date = datetime.datetime.strptime(data["date"], "%Y-%m-%d").strftime("%b %d, %Y")
    title = data["question"]["title"]
    slug = data["question"]["titleSlug"]
    url = f"https://leetcode.com/problems/{slug}/"

    return f"- 📆 {date}: [{title}]({url})"

def update_readme():
    with open(README_PATH, "r", encoding="utf-8") as f:
        content = f.read()

    daily_line = fetch_daily_challenge()

    # Extract current section
    start = content.find(START_TAG) + len(START_TAG)
    end = content.find(END_TAG)
    current = content[start:end].strip().splitlines()

    # Add today's challenge at the top (avoid duplication)
    if daily_line in current:
        return  # Already up-to-date

    updated = [daily_line] + current[:6]  # Keep 7 recent entries

    new_content = (
        content[:start] + "\n" + "\n".join(updated) + "\n" + content[end:]
    )

    with open(README_PATH, "w", encoding="utf-8") as f:
        f.write(new_content)

update_readme()
