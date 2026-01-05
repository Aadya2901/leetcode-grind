class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            String t = tokens[i];
            if (t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/")) {
                int b = st.pop(); 
                int a = st.pop();  

                int result = 0;
                if (t.equals("+")) result = a + b;
                else if (t.equals("-")) result = a - b;
                else if (t.equals("*")) result = a * b;
                else result = a / b;

                st.push(result);
            } else {
                st.push(Integer.parseInt(t));
            }
        }
        return st.pop();
    }}