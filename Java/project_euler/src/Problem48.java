import java.math.BigInteger;

public class Problem48 {
    int numberOfDigits=10;

    BigInteger shorten(BigInteger n){
        String ns=n.toString();
        if(ns.length() <= numberOfDigits){
            return n;
        }
        String s = ns.substring(ns.length()-numberOfDigits,ns.length());
        return new BigInteger(s);
    }

    String calculate(){
        BigInteger res= new BigInteger(0+"");
        for(int n=1; n<=1000; n++){
            BigInteger product=new BigInteger(1+"");
            for(int i=1; i<=n; i++){
                product=product.multiply(new BigInteger(n+""));
                product = shorten(product);
            }
            res=res.add(product);
            res=shorten(res);
        }
        return res.toString().substring(res.toString().length()-numberOfDigits,res.toString().length());
    }
}
