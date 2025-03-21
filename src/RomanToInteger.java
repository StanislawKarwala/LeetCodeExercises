/*
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II.
The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII.
Instead, the number four is written as IV. Because the one is before the five we subtract it making four.
The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.


Example 1:

Input: s = "III"
Output: 3
Explanation: III = 3.
Example 2:

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 3:

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.


Constraints:

1 <= s.length <= 15
s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
It is guaranteed that s is a valid roman numeral in the range [1, 3999].
 */


import java.util.Map;

public class RomanToInteger {
    public static int romanToInt(String s){
        Map<Character, Integer> romanMap = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000
        );

        // Will store final result
        int result = 0;
        // Stores the value of the previous character for comparison
        int previousValue = 0;

        for(int i = s.length()-1; i >= 0; i--){
            int value = romanMap.get(s.charAt(i));

            if(previousValue > value){
                result -= value;
            } else{
                result += value;
            }
            previousValue = value;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));      // 3
        System.out.println(romanToInt("LVIII"));    // 58
        System.out.println(romanToInt("MCMXCIV"));  // 1994
    }
}


/*
Iteracja przez string od końca do początku
String "MCMXCIV" analizujemy od prawej do lewej (od V do M).

Iteracja	i	    Znak	value = romanMap.get(s.charAt(i))	prevValue	Warunek (value < prevValue)	    Operacja	result po operacji	Nowe prevValue
1	        6	    V	                5	                        0	            ❌ (5 >= 0)	                +5	            5	            5
2	        5	    I	                1	                        5	            ✅ (1 < 5)	                -1	            4	            1
3	        4	    C	                100	                        1	            ❌ (100 >= 1)	            +100	        104	            100
4	        3	    X	                10	                        100	            ✅ (10 < 100)	            -10	            94	            10
5	        2	    M	                1000	                    10	            ❌ (1000 >= 10)	            +1000	        1094	        1000
6	        1	    C	                100	                        1000	        ✅ (100 < 1000)	            -100	        994	            100
7	        0	    M	                1000	                    100	            ❌ (1000 >= 100)	        +1000	        1994	        1000
 */
