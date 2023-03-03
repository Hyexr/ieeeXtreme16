//9.77 points (10%)

import java.util.*;
import java.lang.*;
import java.io.*;

// Please name your class Main
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = (int) quickPow(m, n/2);
        if(n>2) k = (k * n/2 -m) % 998244353;
        System.out.println(k);
    }
    static long quickPow(int x, int r) {
        if (r == 0) return 1;
        long half = quickPow(x, r >> 1);
        half = (half % 998244353) * (half % 998244353) % 998244353;
        if((r & 1) == 1) return ((half % 998244353) * x) % 998244353;
        return half;
    }
}
