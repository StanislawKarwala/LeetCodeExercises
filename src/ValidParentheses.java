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