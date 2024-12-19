package algorithms;
public class FindMinMax {
    static class Pair{
        int min;
        int max;
        Pair(int min,int max){
            this.min=min;
            this.max=max;
        }
    }
    
    Pair findMinMax(int a[],int s,int e){
        if(s==e){
            //single element
            return new Pair(a[s], a[s]);
        }
        if(s+1==e){
            if(a[s]>a[e]){
                return new Pair(a[e], a[s]);
            }else{
                return new Pair(a[s], a[e]);
            }
        }
        int m=s+e/2;
        Pair leftPair=findMinMax(a, s, m);
        Pair rightPair=findMinMax(a, m+1, e);
        return new Pair(Math.min(leftPair.min, rightPair.min), Math.max(leftPair.max, rightPair.max));
        
    }
    public static void main(String[] args) {
        FindMinMax n=new FindMinMax();
        int[] a=new int[] {22,-12,1,4,7,-4,9,8};
        Pair minMaX = n.findMinMax(a, 0, a.length-1);
        System.out.println(minMaX.min);
        System.out.println(minMaX.max);
    }

}
