public class RemoveDuplicatesfromSortedArray {
    public static int removeDuplicates(int[] nums){
        if(nums.length == 0){
            return 0;
        }

        int uniqueCount = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[uniqueCount-1]){  // Jeśli nowy element różni się od ostatniego unikalnego
                nums[uniqueCount] = nums[i]; // Zapisujemy go na pozycji k
                uniqueCount++; // Zwiększamy licznik unikalnych elementów
            }
        }
        return uniqueCount;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println("Unique elements count: " + removeDuplicates(arr));
    }
}

/*
nums = [0,0,1,1,1,2,2,3,3,4]
Przechodzimy przez tablicę krok po kroku:

i   | nums[i] | uniqueCount |     nums po zmianach
---------------------
0	    0	        1	        [0, 0, 1, 1, 1, 2, 2, 3, 3, 4]
1	    0	        1	        [0, 0, 1, 1, 1, 2, 2, 3, 3, 4]
2	    1	        2	        [0, 1, 1, 1, 1, 2, 2, 3, 3, 4]
3	    1	        2	        [0, 1, 1, 1, 1, 2, 2, 3, 3, 4]
4	    1	        2	        [0, 1, 1, 1, 1, 2, 2, 3, 3, 4]
5	    2	        3	        [0, 1, 2, 1, 1, 2, 2, 3, 3, 4]
6	    2	        3	        [0, 1, 2, 1, 1, 2, 2, 3, 3, 4]
7	    3	        4	        [0, 1, 2, 3, 1, 2, 2, 3, 3, 4]
8	    3	        4	        [0, 1, 2, 3, 1, 2, 2, 3, 3, 4]
9	    4	        5	        [0, 1, 2, 3, 4, 2, 2, 3, 3, 4]
 */
