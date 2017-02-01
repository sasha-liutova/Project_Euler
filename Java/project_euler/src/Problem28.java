
public class Problem28 {
    int calculate(){
        int diagonalSum=1, cur=1;
        for(int skip=1; skip<=999; skip+=2){
            for(int i=0; i<4; i++){
                cur+=skip+1;
                diagonalSum+=cur;
            }
        }
        return diagonalSum;
    }
}
