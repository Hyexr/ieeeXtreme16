import java.util.*;
import java.lang.*;
import java.io.*;

// Please name your class Main
class Main {
    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] jobs = new int[n];
        for(int i=0;i<n;++i){
            jobs[i] = sc.nextInt();
        }
        Arrays.sort(jobs);
        for(int i=0;i<n;++i){
            jobs[i] = (int) twoPow(jobs[i]);
        }
        if(k>1) System.out.println(jobs[n-1]);
        else{
            int sum = 0;
            for(int i=0;i<n;++i){
                sum = (sum + jobs[i] % 1000000007) % 1000000007;
            }
            System.out.println(sum);
        }
    }
    static long twoPow(int r) {
        if (r == 0) return 1;
        long half = twoPow(r >> 1 );
        half = (half % 1000000007) * (half % 1000000007) % 1000000007;
        if((r & 1) == 1) return ((half % 1000000007) * 2) % 1000000007;
        return half ;
    }
}
