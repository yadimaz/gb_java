package Sem5;

/*/**
 * Написать метод, который переведет число из римского формата записи в арабский.
Например, MMXXIV = 2024

'I', 1
'V', 5
'X', 10
'L', 50
'C', 100
'D', 500
'M', 1000
 */

import java.util.HashMap;
import java.util.Map;

public class ArabFormat {
    public static void main(String[] args) {
        String romanNum = "MMXXIV";
        System.out.println(romanToArabic(romanNum));
    }

    public static Map<Character, Integer> romanArabicMap() {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        return romanMap;

    }

    public static int romanToArabic(String romanNum) {
        Map<Character, Integer> romanMap = romanArabicMap();
        // MMXXIV = 2024
        int result = 0;
        int prevValue = 0;
        for (int i = romanNum.length() - 1; i >= 0; i--) {
            int currentValue = romanMap.get(romanNum.charAt(i));
            if (currentValue < prevValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }
            prevValue = currentValue;
        }
        return result;
    }
}
