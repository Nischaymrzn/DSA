package algorithms;

public class Calculate_Permutation {

    void findPermutation(String str, String perm){
        if(str.isEmpty()){
            System.out.println(perm);
            return;
        }
        for (int i=0;i<str.length();i++){
            char curChar=str.charAt(i);
            String remStr=str.substring(0,i)+str.substring(i+1);
            findPermutation(remStr, perm+curChar);

        }

    }

    public static void main(String[] args) {
        Calculate_Permutation p=new Calculate_Permutation();
        String str="ABC";
        String perm=" ";
        p.findPermutation(str, perm);
        System.out.println("Hello");
    }
}
