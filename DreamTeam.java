//41.46 points (50%)
/* Results
4	1291 ms	14.4 MB	Time limit exceeded
3	1291 ms	15.1 MB	Time limit exceeded
2	228 ms	11.1 MB	OK
1	251 ms	11.2 MB	OK
0	223 ms	10.6 MB	OK
*/

import java.util.*;
import java.lang.*;
import java.io.*;

// Please name your class Main
class Main {
    static int[] bestlist = new int[6];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] slect = new int[5][];
        HashMap<Integer, String> table[] = new HashMap[5];
        for(int i=0;i<5;++i){
            table[i] = new HashMap<>();
        }
        int budget = sc.nextInt();
        for(int k=0;k<5;++k){
            int P = sc.nextInt();
            slect[k] = new int[P];
            sc.nextLine();
            for(int i=0;i<P;++i){
                String[] player = sc.nextLine().split(" ");
                slect[k][i] = Integer.parseInt(player[1]);
                table[k].put(Integer.parseInt(player[1]),player[0]);
            }
        }
        for(int i=0;i<5;++i) Arrays.sort(slect[i]);
        int[] people = new int[5];
        bestlist[5] = 0;
        dfs(slect, budget, 0, 0, people);
        for(int i=0;i<5;++i){
             System.out.println(table[i].get(slect[i][bestlist[i]]));
        }
    }
    static void dfs(int[][] slect, int budget, int deep, int wage, int[] people){
        if(wage > budget) return;
        if(deep >= 5){
            if(bestlist[5] < wage){
                bestlist[5] = wage;
                for(int i=0;i<5;++i){
                    bestlist[i] = people[i];
                }
            }
            return;
        }
        for(int i=0;i<slect[deep].length;++i){
            people[deep] = i;
            dfs(slect, budget, deep+1, wage+slect[deep][i], people);
        }
    }

}
