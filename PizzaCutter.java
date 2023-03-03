import java.util.*;
import java.lang.*;
import java.io.*;

// Please name your class Main
class Main {
    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            HashSet<Integer> kn = new HashSet<>();
            for (int n = 0; n < N; n++) {
                int D = sc.nextInt();
                //角度转换
                kn.add(changeDegree(D));
            }
            if (kn.size()>0) System.out.println(2*kn.size());
            else System.out.println(1);
            
        }
    }
    static int changeDegree(int degree){
        if(degree>=0 && degree <180) return degree;
        if(degree >= 180) return degree % 180;
        else return (degree % 360 + 360) % 180;
    }
}
