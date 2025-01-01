package algorithms;

public class Calculate_Permutation {

    void findPermutation(String str, String perm){
        if(str.isEmpty()){  //base case -> return if string is empty
            System.out.println(perm);
            return;
        }
        for (int i=0;i<str.length();i++){
            char curChar=str.charAt(i);
            String remStr=str.substring(0,i)+str.substring(i+1);
            findPermutation(remStr, perm+curChar);  //recursion case -> call the same function with argument, str without the curr character , and perm by adding current char to it

        }

    }

    public static void main(String[] args) {
        Calculate_Permutation p=new Calculate_Permutation();
        String str="ABC";
        String perm="";
        System.out.println("Permutation of string '" + str + "' are: ");
        p.findPermutation(str, perm);
    }
}
