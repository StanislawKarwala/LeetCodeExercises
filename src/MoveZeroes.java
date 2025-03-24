/*
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
Note that you must do this in-place without making a copy of the array.

Example 1:
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

Example 2:
Input: nums = [0]
Output: [0]
 */

import java.util.Arrays;

public class MoveZeroes {
    public static void moveZeroes(int[] nums){
        int left = 0;

        for(int right = 0; right < nums.length; right++){
            if(nums[right] != 0){
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        moveZeroes(nums);
    }
}

/*
To do that, we use two pointers.

1. Input: nums = [0,1,0,3,12]
[0,1,0,3,12]
 L
 R

2. at index 0, we have 0 value. In that case, we don't do anything. Move right pointer to the next
[0,1,0,3,12]
 L R

3. Now we find 1 which is a non zero number, so it's time to swap left number and right number. In the end,
[1,0,0,3,12]
 L R

4. When we swap two numbers, we move left pointer to the next. And then, move right pointer to the next in the next iteration.
[1,0,0,3,12]
   L R

5. We don't do anything because current number is 0. Move next.
[1,0,0,3,12]
   L   R

6. We find non zero number, swap the left number and right number.
[1,3,0,0,12]
   L   R

7. Then move left pointer to the next. In the next iteration move right to the next.
[1,3,0,0,12]
     L   R

8. we find non zero number. Swap the left number and right number.

[1,3,12,0,0]
     L    R

9. Move left pointer to the next.

[1,3,12,0,0]
        L R
 */
