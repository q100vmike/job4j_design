package algo;
import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {

    public int firstUniqCharMap(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) == 1) {
                return i;
            }
        }
       return -1;
    }

    public int firstUniqChar(String s) {
        int frq  = 0;
        int i = 0;

        for (i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (frq == 1) {
                return i - 1;
            } else {
                frq = 0;
            }
            for (int j = s.length() - 1; j >= 0; j--) {
                char k = s.charAt(j);
                if (frq > 1) {
                    continue;
                }
                if (c == k) {
                    frq++;
                }
            }
        }

        return frq == 1 ? i - 1 : -1;
    }
}


//***********ДЗ:************************
//Решить без использования MAP!

//
//Дана строка s. Найдите первый неповторяющийся символ в этой строке и верните его индекс.
//Если такого символа не существует, верните -1.
//
//Пример 1:
//Ввод: s = "leetcode"
//Вывод: 0
//Пояснение:
//Символ 'l' с индексом 0 — первый символ, который не встречается больше ни на одной позиции.


