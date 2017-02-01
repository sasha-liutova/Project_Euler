import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;

public class Problem26 {

    int [] arr;

    int calculate(){
        arr = new int [10];
        int maxLen=0, maxIndex=0;
        ArrayList<Integer>remainders=new ArrayList<>();
        for (int d=1; d<1000; d++){
            remainders.clear();
            int digits= (int)Math.log10(d) +1;
            int remainder=(int)Math.pow(10,digits);
            for(;;){
                remainder = remainder%d*10;
                if(remainder==0){
                    break;
                }
                if(remainders.contains(remainder)){ // period found
                    int periodLength = remainders.size()-remainders.indexOf(remainder)-2;
                    if(periodLength>maxLen){
                        maxLen=periodLength;
                        maxIndex=d;
                    }
                    break;
                }
                else{
                    remainders.add(remainder);
                }
            }
        }
        System.out.println("period length: " + maxLen);
        return maxIndex;
    }

}
