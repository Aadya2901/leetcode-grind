import java.util.*;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        HashMap<Integer,Integer> map = new HashMap<>();

        // count frequency of nums1
        for(int num : nums1){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        ArrayList<Integer> list = new ArrayList<>();

        // check nums2
        for(int num : nums2){
            if(map.containsKey(num) && map.get(num) > 0){
                list.add(num);
                map.put(num, map.get(num)-1);
            }
        }

        // convert list to array
        int[] result = new int[list.size()];
        for(int i=0;i<list.size();i++){
            result[i] = list.get(i);
        }

        return result;
    }
}