package Leetcode;

public class IndexOfTheFirstOccurrenceInAString {
    // public int strStr(String haystack, String needle) {
        //         int l = needle.length();
        //         if (l == 0) 
        //         {
        //             return 0;
        //         }
        //         for (int i = 0; i <= haystack.length() - l; i++) {
        //             String n = "";
        //             for (int j = i; j < l + i; j++) {
        //                 n = n + haystack.charAt(j);
        //             }
        //             if (n.equals(needle)) {
        //                 return i;
        //             }
        //         }
        //         return -1;
        //     }

        public int strStr(String haystack, String needle) {
            int l = needle.length();
    
            if (l == 0) return 0;
    
            for (int i = 0; i <= haystack.length() - l; i++) {
                if (haystack.substring(i, i + l).equals(needle)) {
                    return i;
                }
            }
    
            return -1;
        }
        public static void main(String[] args) {
            IndexOfTheFirstOccurrenceInAString i=new IndexOfTheFirstOccurrenceInAString();
            System.out.println(i.strStr("nischay", "cha"));
        }
}
