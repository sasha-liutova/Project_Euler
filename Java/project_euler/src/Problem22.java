import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Problem22 {

    ArrayList<String> list;

     private int score(String s){
        int res=0;
        for(int i=0; i<s.length(); i++){
            res+=(s.charAt(i)-64);
        }
        return res;
    }

    private void prepNames(){
        list = new ArrayList<String>();
        File file = new File("p022_names.txt");
        String token="";
        try {
            Scanner input = new Scanner(file);
            token = input.next();
            input.close();
        } catch(Exception e){}

        String cur = "";
        for(int i=0; i<token.length(); i++) {
            char c = token.charAt(i);
            if((c == ',' || c == '\"') && cur!=""){
                list.add(cur);
                cur="";
            }
            else if(c != ',' && c != '\"'){
                cur+=c;
            }
        }

        Collections.sort(list);

    }

    private int countSumm(){
        int res=0;
        for(int i=0; i<list.size(); i++){
            res+= (i+1)*score(list.get(i));
        }
        return res;
    }

    int calculate(){
        prepNames();
        return countSumm();
    }
}
