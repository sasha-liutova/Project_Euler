import java.util.ArrayList;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Problem23 {

    ArrayList<Integer> list;
    boolean[]bitmap;

    private void generateAbundantNumbers(){
        list = new ArrayList<>();
        for(int i=1; i<28124; i++){
            if(isAbundant(i)){
                list.add(i);
            }
        }
    }

    private boolean isAbundant(int n){
        if(divisorsSum(n) > n){
            return true;
        }
        return false;
    }

    private int divisorsSum(int n){
        int sum=0;
        for(int i=1; i<n; i++){
            if(n%i == 0){
                sum+=i;
            }
        }
        return sum;
    }

    private void generateUnwrittableNumbers(){
        bitmap = new boolean[28123];
        for(int i=0;i<28123;i++){
            bitmap[i]=false;
        }
        for(int i=0; list.get(i)<28124/2; i++){
            for(int j=i; list.get(i)+list.get(j)<28124;j++){
                bitmap[list.get(i)+list.get(j)-1]=true;
            }
        }
        for(int i=0; i<28123; i++){
            if(bitmap[i] == false){
                System.out.println(i+1);
            }
        }
    }

    private int getUnwrittableNumbersSum(){
        int sum = 0;
        for(int i=0; i<28123; i++){
            if(bitmap[i] == false){
                sum+=i+1;
            }
        }
        return sum;
    }

    int calculate(){
        generateAbundantNumbers();
        generateUnwrittableNumbers();
        return getUnwrittableNumbersSum();
    }

}
