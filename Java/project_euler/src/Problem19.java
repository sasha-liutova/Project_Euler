import java.util.ArrayList;

public class Problem19 {
    int [] months = {-1,31,-1,31,30,31,30,31,31,30,31,30,31};

    boolean isLeap(int year){
        if(year%400 == 0)
            return true;
        if(year%100 == 0)
            return false;
        if(year%4 == 0)
            return true;
        else
            return false;
    }

    int calculate (){
        int res=0;
        int cur = 2;
        for(int year=1901; year<=2000; year++){
            for(int month =1; month<=12; month++){
                if(month != 2){
                    cur+=months[month];
                }
                else{
                    if(isLeap(year)){
                        cur+=29;
                    }
                    else{
                        cur+=28;
                    }
                }
                cur=cur%7;
                if(cur==0){
                    res++;
                }
            }
        }

        return res;
    }

}
