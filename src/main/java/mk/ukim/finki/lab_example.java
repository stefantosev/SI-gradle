package mk.ukim.finki;

import java.util.List;

public class lab_example {

    //Steps:
    //step 1 -> CFG da se nacrta
    //step 2 -> ciklomatska kompleksnost da se odredi(po br na regioni); V = E(edges) - N(nodes) + 2; predicate nodes +1): 5
    //step 3 -> da se napravi tabela za everyStatement(C0), everyBranch(C1), eceryPath, multipleCondition
    //step 4 -> write tests from table

    public static double sumOfPricesGreaterThan (List<Double> prices, Double value){ //1
        if(prices==null || prices.isEmpty()) //2
            throw new RuntimeException("List of prices is not ok"); //3
        double sum =0; //4
         for(int i=0; i<prices.size(); i++){ //5  -> go delime vo cfg kako while: 5.1(i=0), 5.2(uslov), 5.3(inkrement)
             if(prices.get(i)<0)// 6
                 throw new RuntimeException("Negative price is not allowed"); //7 odi vo 12 zavrsue progr
             if(prices.get(i)>value) //8
                 sum+=prices.get(i); //9
         } //10 od tuka odi vo 5.3 za inkrement na i
         return sum; //11
    }  //12
}