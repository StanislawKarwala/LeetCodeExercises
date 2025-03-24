import java.util.*;

public class IntersectionofTwoArrays {
    public static int[] intersection(int[] nums1, int[] nums2){
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for(int num : nums1){
            map.put(num, 1);
        }

        for(int num : nums2){
            if(map.containsKey(num) && map.get(num) == 1){
                list.add(num);
                map.put(num, 0);
            }
        }

        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2, 2};
        int[] nums3 = new int[]{4, 9, 5};
        int[] nums4 = new int[]{9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
        System.out.println(Arrays.toString(intersection(nums3, nums4)));
    }
}
