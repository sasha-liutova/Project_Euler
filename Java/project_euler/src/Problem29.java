import java.math.BigInteger;
import java.util.HashSet;

public class Problem29 {

    int calculate(){
        HashSet<BigInteger> set = new HashSet<>();
        for(int a=2; a<=100; a++){
            for(int b=2; b<=100; b++){
                BigInteger n = new BigInteger(a+"");
                n = n.pow(b);
                set.add(n);
            }
        }
        return set.size();
    }
}
