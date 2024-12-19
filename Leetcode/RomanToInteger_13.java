package leetcode;

public class RomanToInteger_13 {

    public int romanToInt(String s) {
        // Create an array for Roman numeral values
        int[] romanValues = new int[128]; // Create an array of size 128 (to handle ASCII values)
        
        // Assigning values to the Roman numeral characters
        romanValues['I'] = 1;
        romanValues['V'] = 5;
        romanValues['X'] = 10;
        romanValues['L'] = 50;
        romanValues['C'] = 100;
        romanValues['D'] = 500;
        romanValues['M'] = 1000;

        int total = 0;

        // Iterate through the string
        for (int i = 0; i < s.length(); i++) {
            // If current numeral is smaller than the next one, subtract it
            if (i < s.length() - 1 && romanValues[s.charAt(i)] < romanValues[s.charAt(i + 1)]) {
                total -= romanValues[s.charAt(i)];
            } else {
                total += romanValues[s.charAt(i)];
            }
        }

        return total;
    }

    public static void main(String[] args) {
        RomanToInteger_13 r = new RomanToInteger_13();
        System.out.println(r.romanToInt("MMM")); // Output: 3000
    }
}
