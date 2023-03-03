import java.util.*;
import java.io.*;

// Please name your class Main
class Main {
    public static void main (String[] args)  {
        Scanner s = new Scanner(System.in);
        String str1 = s.nextLine().toString();
        String str = str1.toLowerCase();
        char arr[]=str.toCharArray();
        int n = str.length();
        char arr1[] = new char[n];
        for(int i = 0; i < n; i++) {
            //会显示格式错误，char c = c1 + 1;
            char c2 = ' ';
            if(!Character.isLowerCase(arr[i])){
                c2 = arr[i];
            }else{
                c2 = (char) (arr[i] - 12);
                if (c2 - 'a' < 0) {
                    c2 = (char) (c2 + 26);
                }
            }
            arr1[i] = c2;
        }
        char initial[]=str1.toCharArray();
        for(int i = 0; i < n; i++){
            if(Character.isUpperCase(initial[i])){
                arr1[i] = Character.toUpperCase(arr1[i]);
            }
        }
        System.out.println(arr1);
    }
}
