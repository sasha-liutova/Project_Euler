
import java.util.ArrayList;

public class Problem21 {

    ArrayList<Integer> divSums;

    int calculate(){
        int res = 0;

        divSums = new ArrayList<Integer>();
        for(int num =1; num<=10000; num++){
            int sum=0;
            for (int i=1; i<num; i++){
                Double div = (double)num/(double)i;
                if(div.compareTo((double)div.intValue()) == 0){
                    sum+=i;
                }
            }
            divSums.add(sum);
        }

        boolean[]bitmap = new boolean[10000];
        for(int i=0; i<10000; i++){
            bitmap[i]=false;
        }

        for(int num=1; num<=10000; num++){
            int num2=divSums.get(num-1);
            try{
            if(num2>0 && num2<=10000 && divSums.get(num2-1) == num && num!=num2){
                bitmap[num-1]=true;
                bitmap[num2-1]=true;
            }}
            catch(Exception e){
                System.out.println("num2 = " + num2 + ", num = " + num);
            }
        }

        for(int i=0; i<10000; i++){
            if(bitmap[i]==true){
                res+=i+1;
            }
        }

        return res;
    }

    Integer checkAt(int index){
        if(divSums == null || divSums.size()<index || index<1){
            return -1;
        }
        else{
            return divSums.get(index-1);
        }
    }

}
