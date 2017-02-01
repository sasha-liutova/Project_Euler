import java.util.ArrayList;

public class Problem30 {

    int calculate(){
        int res=0;
        for(int digits=2; digits<8; digits++){
            int from = (int)Math.pow(10,digits-1);
            int to = (int)Math.pow(10,digits);
            for(int n=from; n<to; n++){
                int sum = 0;
                for(int i=0; i<digits; i++){
                    int t = (n+"").charAt(i)-48;
                    sum+=Math.pow(t, 5);
                }
                if(sum == n){
                    res+=n;
                }
            }
        }
        return res;
    }
}
