import java.util.*;

public class IntersectionofTwoArrays2 {
    public static int[] intersect(int[] nums1, int[] nums2){
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for(int num : nums1){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int num : nums2){
            if(map.containsKey(num) && map.get(num) > 0){
                result.add(num);
                map.put(num, map.get(num) - 1);
            }
        }

        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2, 2};
        int[] nums3 = new int[]{4, 9, 5};
        int[] nums4 = new int[]{9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
        System.out.println(Arrays.toString(intersect(nums3, nums4)));
    }
}
