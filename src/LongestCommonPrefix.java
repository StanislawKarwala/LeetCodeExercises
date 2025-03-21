/*
Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 */

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs){
        if(strs.length == 0) return "";

        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++){
            while(strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0, prefix.length()-1);
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] common = new String[]{"flower", "flow", "flight"};
        String[] notCommon = new String[]{"dog", "racecar", "car"};
        System.out.println(longestCommonPrefix(common));
        System.out.println(longestCommonPrefix(notCommon));
    }
}

/*
Wejście:
String[] strs = {"flower", "flow", "flight"};

1️⃣ Ustawiamy prefix = "flower"
➡️ Pierwsze słowo to "flower", więc na początku prefix = "flower".

2️⃣ Porównujemy prefix z "flow"
➡️ "flow".indexOf("flower") == -1 ❌ → Skracamy prefix:
- "flower" → "flowe"
- "flowe" → "flow" ✅ "flow".indexOf("flow") == 0 ✔️ → Przechodzimy do następnego słowa.

3️⃣ Porównujemy prefix = "flow" z "flight"
➡️ "flight".indexOf("flow") == -1 ❌ → Skracamy prefix:
- "flow" → "flo"
- "flo" → "fl" ✅ "flight".indexOf("fl") == 0 ✔️ → Koniec.
🔹 Wynik: "fl"
 */
