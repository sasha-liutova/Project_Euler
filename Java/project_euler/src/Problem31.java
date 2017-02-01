import java.util.HashSet;


public class Problem31 {

    int[]values = {200,100, 50, 20, 10, 5, 2, 1};
    int arrSize=8;
    int limit=200;
    int res;


    int arrValue(int[]arr){
        int res=0;
        for(int i=0; i<arrSize; i++){
            res+=arr[i]*values[i];
        }
        return res;
    }

    int[]increaseArr(int[]arr, int index, int val){
        int[]arr2 = new int[arrSize];
        for(int i=0; i<arrSize; i++){
            arr2[i]=arr[i];
        }
        arr2[index]+=val;
        return arr2;
    }

    void calculateRec(int[]arr, int index){
        int val = arrValue(arr);
        if( val == limit){
            res++;
        }
        else if(val<limit && index<arrSize){
            int top = (limit-val)/values[index] + 1;
            for(int i=0; i<=top; i++){
                calculateRec(increaseArr(arr,index, i), index+1);
            }
        }
    }

    int calculate(){
        res=0;
        int[]arr = new int[arrSize];
        for(int i=0; i<arrSize; i++){
            arr[i]=0;
        }
        calculateRec(arr, 0);
        return res;
    }

}
