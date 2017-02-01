
public class Problem24 {

    int[] factorials;
    int limit = 1000000;

    private void fillFactorials(){
        factorials = new int [10];
        factorials[0]=1;
        for(int i=1; i<10; i++){
            factorials[i]=factorials[i-1]*(i+1);
        }
    }

    void shift(int[]arr, int t){
        for(int i=t; i<9; i++){
            arr[i]=arr[i+1];
        }
        arr[9]=-1;
    }

    void calculate(){
        fillFactorials();
        int[]arr = new int [10];
        for(int i=0; i<10; i++){
            arr[i]=i;
        }
        int[]res = new int [10];
        int current=0;
        int num;

        for(int i=9; i>0; i--){
            num = (limit-current)/factorials[i-1];
            if((limit-current)%factorials[i-1] == 0) num--;
            res[9-i]=arr[num];
            shift(arr, num);
            current += num*factorials[i-1];
        }
        res[9]=arr[0];

        for(int i=0; i<10; i++){
            System.out.print(res[i]);
        }
    }

}
