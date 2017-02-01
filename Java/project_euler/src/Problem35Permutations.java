
public class Problem35Permutations {
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

    boolean permutationRec(String prefix, String str) {
        int n = str.length();
        if (n == 1){
            if(isPrime(Integer.parseInt(prefix+str))){
                return true;
            }
            else{
                return false;
            }
        }
        else {
            for (int i = 0; i < n; i++) {
                if(permutationRec(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n)) == false){
                    return false;
                }
            }
        }
        return true;
    }

    boolean checkPermutations(String s){
        return permutationRec("", s);
    }

    int calculate(){
        res=1;

        for(int n=3; n<1000000; n+=2){
            if(isPrime(n) && checkPermutations(n+"")){
                System.out.println(n);
                res++;
            }
        }

        return res;
    }
}
