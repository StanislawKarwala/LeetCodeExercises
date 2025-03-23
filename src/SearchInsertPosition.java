/*
Given a sorted array of distinct integers and a target value, return the index if the target is found.
If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [1,3,5,6], target = 5
Output: 2

Example 2:
Input: nums = [1,3,5,6], target = 2
Output: 1

Example 3:
Input: nums = [1,3,5,6], target = 7
Output: 4
 */

public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,4,5,8};
        System.out.println(searchInsert(arr, 3));
    }
}

/*
nums = [1, 3, 5, 6] i target = 2
left = 0;
right = 3;

1. Inicjalizacja
Indeksy:   0   1   2   3
Wartości:  1   3   5   6
left ->    ^
right ->               ^

2. while (left <= right)
left (0) <= right (3) → TAK, więc wchodzimy do pętli.

3. Znajdujemy mid (mid = left + (right - left) / 2)
mid = 0 + (3 - 0) / 2
mid = 1

Indeksy:   0   1   2   3
Wartości:  1   3   5   6
left ->    ^
mid ->         ^
right ->               ^

4. Sprawdzamy, czy nums[mid] == target
nums[1] = 3, ale target = 2.

5. Czy target jest większy niż nums[mid]?
- 2 < 3, więc target jest mniejszy.
- Skoro target jest mniejszy, oznacza to, że musimy szukać w lewej części tablicy.
- Przesuwamy right = mid - 1 = 1 - 1 = 0.

Tablica po zmianie right:
Indeksy:   0   1   2   3
Wartości:  1   3   5   6
left ->    ^
right ->   ^

6. Pętla while (left <= right) – kolejna iteracja
- left (0) <= right (0) → TAK, więc kontynuujemy.
- mid = 0 + (0 - 0) / 2 = 0
- Teraz mid = 0, więc sprawdzamy nums[0].

Tablica:
Indeksy:   0   1   2   3
Wartości:  1   3   5   6
left ->    ^
mid ->     ^
right ->   ^

7. Sprawdzamy nums[mid] == target
nums[0] = 1, ale target = 2, więc nie znaleźliśmy.

8. Czy target jest większy niż nums[mid]?
- 2 > 1, więc target jest większy.
- Musimy szukać w prawej części tablicy.
- Przesuwamy left = mid + 1 = 0 + 1 = 1.

Tablica po zmianie left:
Indeksy:   0   1   2   3
Wartości:  1   3   5   6
left ->        ^
right ->   ^

9. Sprawdzamy warunek pętli while (left <= right)
left (1) > right (0) → FAŁSZ, więc wychodzimy z pętli.

10. Zwracamy left jako wynik
left = 1, czyli indeks, na którym powinien być target = 2.
Ostateczny wynik: 1, co oznacza, że 2 powinno być wstawione na indeks 1, czyli przed 3.
 */
