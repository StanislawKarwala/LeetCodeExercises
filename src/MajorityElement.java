/*
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times.
You may assume that the majority element always exists in the array.

Example 1:
Input: nums = [3,2,3]
Output: 3

Example 2:
Input: nums = [2,2,1,1,1,2,2]
Output: 2
 */

public class MajorityElement {
    // algorytm Boyera-Moore’a
    public static int majorityElement(int[] nums){
        int major = nums[0];
        int count = 1;

        for(int i = 1; i < nums.length; i++){
            if(nums[i] == major){
                count++;
            } else {
                count--;
            }

            if(count == 0){
                major = nums[i];
                count = 1;
            }
        }
        return major;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 3};
        int[] nums1 = new int[]{2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
        System.out.println(majorityElement(nums1));
    }
}

/*
Algorytm Boyera-Moore’a to efektywny algorytm służący do znajdowania elementu większościowego w tablicy
(tj. elementu, który występuje więcej niż ⌊n/2⌋ razy).
Działa w czasie liniowym O(n) i wykorzystuje tylko stałą dodatkową pamięć O(1).

1. Inicjalizacja zmiennych
int major = nums[0];
int count = 1;
- major przechowuje aktualnie wybranego kandydata na element większościowy.
Początkowo ustawiamy go na pierwszy element tablicy nums[0].
- count przechowuje liczbę głosów dla bieżącego kandydata.
Na początku ustawiamy go na 1, bo mamy już jeden wystąpienie major.

2. Iteracja po tablicy

3. Sprawdzanie, czy obecny element pasuje do kandydata
if (nums[i] == major) {
    count++;
}
- Jeśli aktualny element nums[i] jest taki sam jak major, to zwiększamy licznik count,
ponieważ ten kandydat zdobywa kolejny głos.

4. Jeśli element jest inny – zmniejszamy licznik
else {
    count--;
}
- Jeśli aktualny element nums[i] jest inny niż major, to zmniejszamy count, co oznacza,
że napotkaliśmy element przeciwny do naszego kandydata.

5. Jeśli licznik spadnie do zera – zmieniamy kandydata
if (count == 0) {
    major = nums[i];
    count = 1;
}
- Jeśli licznik count spadnie do 0, oznacza to, że dotychczasowy kandydat przestał dominować.
- Wybieramy nowego kandydata (nums[i]), a jego licznik ustawiamy na 1, bo traktujemy go jako potencjalnego zwycięzcę.

| i  | nums[i] | major | count | Opis działania
|----|-------- |-------|-------|---------------------------------------------
|  0 |   2     |   2   |   1   | Startujemy z pierwszym elementem
|  1 |   2     |   2   |   2   | Kolejny 2, więc zwiększamy count
|  2 |   1     |   2   |   1   | Inny element (1), zmniejszamy count
|  3 |   1     |   2   |   0   | Kolejny 1, count spada do 0 – zmiana kandydata
|  4 |   1     |   1   |   1   | 1 staje się nowym major
|  5 |   2     |   1   |   0   | 2 zmniejsza count do 0 – zmiana kandydata
|  6 |   2     |   2   |   1   | 2 staje się nowym major
 */
