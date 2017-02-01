
public class Problem35 {
    int res;

    boolean isPrime(int n){
        if((n%2==0 && n!=2) || n<2){
            return false;
        }
        for(int i=3; i<=n/2; i+=2){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }

    String shift(String s){
        return s.substring(1,s.length()) + s.charAt(0);
    }

    int calculate(){
        res=1;
        for(int n=3; n<1000000; n+=2){
            boolean check=true;
            String current=n+"";
            for(int i=0; i<current.length(); i++){
                if(!isPrime(Integer.parseInt(current))){
                    check=false;
                    break;
                }
                current = shift(current);
            }
            if(check){
                System.out.println(n);
                res++;
            }
        }
        return res;
    }
}
