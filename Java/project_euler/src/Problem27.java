
public class Problem27 {

    boolean isPrime(int n){
        if(n%2==0 || n<1){
            return false;
        }
        for(int i=3; i<=n/2; i+=2){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }

    int calculate(){
        int primes=0, product=0;
        for(int a =-999; a<1000; a++){
            for(int b=-999; b<1000; b++){
                int curentPrimes=0;
                for(int n=0; ;n++){
                    int sum = n*n + a*n + b;
                    if(isPrime(sum)){
                        curentPrimes++;
                    }
                    else{
                        break;
                    }
                }
                if(curentPrimes>primes){
                    primes=curentPrimes;
                    product=a*b;
                }
            }
        }
        System.out.println("# of primes = " + primes);
        return product;
    }
}
