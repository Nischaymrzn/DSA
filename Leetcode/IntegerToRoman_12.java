package leetcode;

public class IntegerToRoman_12 {
    public String intToRoman(int num) {
        // Arrays for Roman numerals for each place (thousands, hundreds, tens, ones)
        int[] values = {1000, 900, 500, 400,100,90,50,40,10,9,5,4,1};
        String[] operator = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX","V","IV","I"};
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<values.length;i++){
            if(num==0){
                break;
            }
            while(num>=values[i]){
                num-=values[i];
                sb.append(operator[i]);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        IntegerToRoman_12 i=new IntegerToRoman_12();
        System.out.println(i.intToRoman(1200));
    }
}
