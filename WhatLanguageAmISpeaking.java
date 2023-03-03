import java.util.*;
import java.lang.*;
import java.io.*;

// Please name your class Main
class Node{
    String lang;
    Node left;
    Node right;
    boolean isEnd;
    Node(){}
    Node(String lang, boolean flag){
        this.lang = lang;
        this.isEnd = flag;
    }

}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        //建立决策树
        HashMap<Integer, Node> table1 = new HashMap<>(n);
        HashMap<Integer, int[]> table2 = new HashMap<>(n);
        HashSet<Integer> check = new HashSet<>();
        sc.nextLine();
        for(int i=0;i<n;++i) {
            String ju = sc.nextLine();
            String[] fen = ju.split(" ");
            if(fen.length > 3){
                table1.put(Integer.parseInt(fen[1]), new Node(fen[2], false));
                table2.put(Integer.parseInt(fen[1]), new int[]{Integer.parseInt(fen[3]),Integer.parseInt(fen[4])});
                check.add(Integer.parseInt(fen[1]));
            }else{
                table1.put(Integer.parseInt(fen[1]), new Node(fen[2], true));
            }
        }
        for(Map.Entry<Integer, int[]> entry:table2.entrySet()){
            Node father = table1.get(entry.getKey());
            father.left = table1.get(entry.getValue()[0]);
            father.right = table1.get(entry.getValue()[1]);
            if(check.contains(entry.getValue()[0])) check.remove((entry.getValue()[0]));
            if(check.contains(entry.getValue()[1])) check.remove((entry.getValue()[1]));
        }
        Node root = new Node();
        for(Integer i:check){
            root = table1.get(i);
        }
        //判断
        for(int i=0;i<p;++i) {
            String unknowLang = sc.nextLine();
            String langs = jud(unknowLang, root);
            System.out.println(langs);
        }
    }
    static String jud(String lang, Node root){
        Node tmp = root;
        boolean flag = true;
        while(!tmp.isEnd){
            if(lang.contains(tmp.lang)) {
                flag = true;
                tmp = tmp.left;
            }
            else {
                flag = false;
                break;
            }
        }
        if(flag) return tmp.lang;
        tmp = root;
        List<String> maybeLang = new ArrayList<>();
        maybeLang = dfs(lang, root, maybeLang);
        Collections.sort(maybeLang);
        StringBuffer a = new StringBuffer();
        for(String str:maybeLang) {
            a.append(str);
            a.append(" ");
        }
        return a.toString();
    }
    static List<String> dfs(String lang, Node node, List<String> langTable){
        if(node.isEnd) {
            langTable.add(node.lang);
            return langTable;
        }
        if(lang.contains(node.lang)) langTable=dfs(lang, node.left, langTable);
        else {
            langTable=dfs(lang, node.left, langTable);
            langTable=dfs(lang, node.right, langTable);
        }
        return langTable;
    }
}
