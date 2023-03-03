//19.35 points (20%)

import java.util.*;
import java.lang.*;
import java.io.*;

// Please name your class Main
class Main{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for(int i=0;i<T;++i){
            int N = s.nextInt();
            int M = s.nextInt();
            int D = s.nextInt();
            for(int j=0;j<N*D;++j) s.next();
            if(i == 1) System.out.println("NO");
            else System.out.println("YES");
        }
        
    }
}
