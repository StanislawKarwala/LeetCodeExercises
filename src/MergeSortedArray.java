import java.util.Arrays;

public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n){
        int p = m + n - 1;
        int p1 = m - 1;
        int p2 = n - 1;

        while(p1 >= 0 && p2 >= 0){
            if(nums1[p1] > nums2[p2]){
                nums1[p] = nums1[p1];
                p1--;
                p--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
                p--;
            }
        }

        while(p2 >= 0){
            nums1[p] = nums2[p2];
            p2--;
            p--;
        }
        System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};

        merge(nums1, 3, nums2, 3);
    }
}

/*
int p - pointer wskazujący na ostatni element w tablicy nums1[1, 2, 3, 0, 0 , 0] - czyli nums[5] = 0;
int p1 = pointer wskazujący na ostatni element różny od 0 w tablicy nums1, czyli nums[2] = 3;
int p2 = pointer wskazujący na ostatni element w tablicy nums2[2, 5, 6] - czyli nums[2] = 6;
*/
