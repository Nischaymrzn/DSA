package dataStructures;

public class DynamicProgrammingExample {
    static int fib(int n, int[] dp){
        if(n<=1){
            return n;
        }
        if(dp[n]!=0){
            return dp[n];  //if the index 0 dp[0] has value, it doesn't call teh down part recursion, rather return the value in the given index
        }
        dp[n]= fib(n-1,dp)+fib(n-2,dp);  //calls the recursion and value is returned to dp[n], such as dp[0]=0,dp[1]=1,dp[2]=0+1=1,dp[3]=2
        return dp[n];
    }
    public static void main(String[] args){
        int n=9000;
        System.out.println("The fibonacci is");
        int[] dp=new int[n+1];  //storing the value in the memory, so that it can be used in same type of problem instead of redundancy, known as Memoization
        System.out.println(fib(n,dp));
    }
}
