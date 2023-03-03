import java.util.*;
import java.lang.*;
import java.io.*;

// Please name your class Main
import java.util.*;

public class Main {
    public static void main(String[] args) {
        char[][] ren = new char[3][];
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=0;i<T;++i){
            int mode = 0;
            int d = sc.nextInt();
            ren = buildRen(ren);
            sc.nextLine();
            for(int j=0;j<d;++j){
                String command = sc.nextLine();
                if(command.matches("say.*")) {
                    System.out.println(command.substring(4));
                }else if(command.matches(".*hand.*")){
                    ren = changeHand(command, ren, mode);
                    for(int k=0;k<3;++k)System.out.println(ren[k]);
                }else if(command.matches(".*leg.*")){
                    ren = changeLeg(command, ren, mode);
                    for(int k=0;k<3;++k)System.out.println(ren[k]);
                }else if(command.matches(".*turn.*")){
                    mode = mode^1;
                    ren = changeDirect(ren);
                    for(int k=0;k<3;++k)System.out.println(ren[k]);
                }
//                for(int k=0;k<3;++k)System.out.println(ren[k]);
            }
        }
    }
    static char[][] buildRen(char[][] ren){
        ren[0] = new char[] {' ','o',' '};
        ren[1] = new char[] {'/','|','\\'};
        ren[2] = new char[] {'/',' ','\\'};
        return ren;
    }
    static char[][] changeDirect(char[][] ren){
        char[][] changed = new char[3][3];
        for(int i=0;i<3;++i){
            for(int j=0;j<3;++j){
                changed[i][j] = ren[i][2-j];
                if(changed[i][j] == '<') changed[i][j] = '>';
                else if (changed[i][j] == '>') changed[i][j] = '<';
                else if (changed[i][j] == '(') changed[i][j] = ')';
                else if (changed[i][j] == ')') changed[i][j] = '(';
                else if (changed[i][j] == '/') changed[i][j] = '\\';
                else if (changed[i][j] == '\\') changed[i][j] = '/';
            }
        }
        return changed;
    }
    static char[][] changeHand(String command, char[][] ren, int mode){
        int direct = 0;
        if(command.matches(".*right.*")) direct = 1;
        if(mode == 1){
            direct = direct^1;
        }
        if(direct == 1 && command.matches(".*hip.*")) {
            ren[0][0] = ' ';
            ren[1][0] = '<';
        }
        else if(direct == 1 && command.matches(".*head.*")) {
            ren[0][0] = '(';
            ren[1][0] = ' ';
        }else if(direct == 1 && command.matches(".*start.*")){
            ren[0][0] = ' ';
            ren[1][0] = '/';
        }else if(direct == 0 && command.matches(".*hip.*")) {
            ren[0][2] = ' ';
            ren[1][2] = '>';
        }
        else if(direct == 0 && command.matches(".*head.*")) {
            ren[0][2] = ')';
            ren[1][2] = ' ';
        }else if(direct == 0 && command.matches(".*start.*")){
            ren[0][2] = ' ';
            ren[1][2] = '\\';
        }
        return ren;
    }
    static char[][] changeLeg(String command, char[][] ren, int mode){
        int direct = 0;
        if(command.matches(".*right.*")) direct = 1;
        if(mode == 1){
            direct = direct^1;
        }
        if(direct == 1 && command.matches(".*in.*")) {
            ren[2][0] = '<';
        }
        else if(direct == 1 && command.matches(".*out.*")) {
            ren[2][0] = '/';
        }
        else if(direct == 0 && command.matches(".*in.*")) {
            ren[2][2] = '>';
        }else if(direct == 0 && command.matches(".*out.*")){
            ren[2][2] = '\\';
        }
        return ren;
    }
}
