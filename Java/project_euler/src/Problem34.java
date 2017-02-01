
public class Problem34 {
    int[] factorials;

    private void fillFactorials(){
        factorials = new int [10];
        factorials[0]=factorials[1]=1;
        for(int i=2; i<10; i++){
            factorials[i]=factorials[i-1]*i;
        }
    }

    int calculate(){
        fillFactorials();
        int res=0;
        for(int digits=2; digits<8; digits++){
            int from = (int)Math.pow(10,digits-1);
            int to = (int)Math.pow(10,digits);
            for(int n=from; n<to; n++){
                int sum = 0;
                for(int i=0; i<digits; i++){
                    int t = (n+"").charAt(i)-48;
                    sum+=factorials[t];
                }
                if(sum == n){
                    res+=n;
                }
            }
        }
        return res;
    }
}
