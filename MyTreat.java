import java.lang.*;
import java.io.*;
import java.util.*;
import javax.xml.namespace.QName;

class Main{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();


        for(int i = 0; i < num; i++){
            int TreatNum = 0;
            int Days = 0;
            int Meal = s.nextInt();

            HashMap<String, Integer> treatMap = new HashMap<>();
            for(int j = 0; j < Meal; j++){
                String CostName = s.next();
                int CostNum = s.nextInt();
                for(int k = 0; k < CostNum; k++){
                    String EatName = s.next();
                    int EatNameCost = treatMap.getOrDefault(EatName, 0);
                    treatMap.put(EatName, EatNameCost - 1);
                }
                int CostNameCost = treatMap.getOrDefault(CostName, 0);
                treatMap.put(CostName,  CostNameCost + CostNum);
            }

            for(int iValue : treatMap.values()){



                if(iValue < 0){
                }
                else{
                    TreatNum += iValue;
                    Days = Math.max(iValue, Days);
                }
            }
            System.out.println(TreatNum + " " + Days);
        }
    }
}
