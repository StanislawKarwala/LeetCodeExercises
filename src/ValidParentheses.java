/*
iven a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.
3. Every close bracket has a corresponding open bracket of the same type.

Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false

Example 4:
Input: s = "([])"
Output: true
 */

import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(c == '('){
                stack.push(')');
            } else if(c == '['){
                stack.push(']');
            } else if(c == '{'){
                stack.push('}');
            } else if(stack.isEmpty() || stack.pop() != c){
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("({})"));
        System.out.println(isValid("({}])"));
        System.out.println(isValid("[({[]})]"));
    }
}

/*
🟢 Poprawne wejście:
isValid("({[]})");

Krok | Znak  | Stos
---------------------
1    | (     | )
2    | {     | )}
3    | [     | )}]
4    | ]     | )} (pop ])
5    | }     | ) (pop })
6    | )     | empty (pop ))
✅ Zwraca true, bo stos jest pusty.

🔴 Błędne wejście:
isValid("({[)]}");

Krok | Znak  |         Stos         | Co się dzieje
------------------------------------------
1    | (     |          )           | Dodajemy )
2    | {     |          )}          | Dodajemy }
3    | [     |          )}]         | Dodajemy ]
4    | )     |      )} (pop ] ❌)   | ❌ Błąd → ] ≠ )
🔴 Zwraca false, bo zamykający nawias ) nie pasuje do ].

 */