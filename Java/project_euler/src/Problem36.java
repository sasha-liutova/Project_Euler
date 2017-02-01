import java.math.BigDecimal;

public class Problem36 {
    private boolean isPalindromic(String s){
        if(s.isEmpty()) return true;
        int left=0, right=s.length()-1;
        while(left<=s.length()/2){
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private String toBinary(int n){
        String res="";
        while(n>0){
            res+=n%2;
            n/=2;
        }
        return new StringBuilder(res).reverse().toString();
    }

    private boolean isCurious(String s){
        int n = Integer.parseInt(s);
        if(isPalindromic(toBinary(n))){
            return true;
        }
        return false;
    }

    String mirror(int n, int t){
        String res = n+"";
        if(t>=0){
            res+=t;
        }
        StringBuilder sb = new StringBuilder(n+"");
        res+=sb.reverse().toString();;
        return res;
    }

    int calculate(){
        int res=0, n=1, digits=1, limit=3;
        String current;
        for(int i=0; i<10; i++){
            if(isCurious(i+"")){
                res+=i;
            }
        }
        while(digits<=limit){
            current=mirror(n,-1);
            if(isCurious(current)){
                res+=Integer.parseInt(current);
            }
            if(digits!=limit){
                for(int i=0; i<10; i++){
                    current=mirror(n,i);
                    if(isCurious(current)){
                        res+=Integer.parseInt(current);
                    }
                }
            }
            n++;
            digits=(n+"").length();
        }
        return res;
    }
}
