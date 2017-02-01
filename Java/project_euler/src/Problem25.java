import java.math.BigDecimal;
import java.math.BigInteger;

public class Problem25 {

    BigDecimal a;
    BigDecimal b;
    BigDecimal c;

    private void fillParams(){
        BigDecimal s = new BigDecimal("2.2360679774997896964091736687312762354406183596115257242708972454105209256378");
//                "04899414414408378782274969508176150773783504253267724447073863586360121533452708")+
//                "86677817319187916581127664532263985658053576135041753378500342339241406444208643")+
//                "25390972525926272288762995174024406816117759089094984923713907297288984820886415")+
//                "42689894099131693577019748678884425089754132956183176921499977424801530434115035" +
//                "95766833251249881517813940800056242085524354223555610630634282023409333198293395" +
//                "97463522712013417496142026359047378855043896870611356600457571399565955669569175")+
//                "64578221952500060539231234005009286764875529722056766253666074485853505262330678" +
//                "49463342224231763727702663240768010444331582573350589309813622634319868647194698" +
//                "99701808189524264459620345221411922329125981963258111041704958070481204034559949" +
//                "43506855551855572512388641655010262436312571024449618789424682903404474716115455" +
//                "72320173767659046091852957560357798439805415538077906439363972302875606299948221" +
//                "38521773485924535151210463455550407072278724215347787529112121211843317893351910" +
//                "38008011118179004590618846249647104244248308880129406811314695953279447898998931");
        c = new BigDecimal(10);
        c = c.pow(999);
        c = c.multiply(s);
        System.out.println("c = " + c);
        System.out.println("c # = " + c.toString().length());
        a = new BigDecimal(1);
        a = a.add(s);
        a = a.divide(new BigDecimal(2));
        System.out.println("a = " + a);
        b = new BigDecimal(1);
        b = b.subtract(s);
        b = b.divide(new BigDecimal(2));
        System.out.println("b = " + b);
    }

    void check(){ // checked: val is in (1000;10000)
        fillParams();
        BigDecimal a1, b1, v;
        for (int i=1; ; i*=10){
            System.out.print("checking " + i + " ");
            a1 = a.pow(i);
            b1 = b.pow(i);
            v = a1.subtract(b1);
            if(v.compareTo(c) >0){
                System.out.println(i);
                break;
            }
        }
    }

    void count(){ // in (4780;4790) 4787 - already bigger
        BigDecimal a1, b1, v;
        for (int i=4780; ; i+=1){
            System.out.print("i=" + i + " ");
            a1 = a.pow(i);
            b1 = b.pow(i);
            v = a1.subtract(b1);
            if(v.compareTo(c) >0 || v.compareTo(c)==0){
                System.out.println(i);
                break;
            }
        }
    }

    void checknum(int n){
        System.out.print("checking number " + n + " ... ");
        BigDecimal a1, b1, v;
        a1 = a.pow(n);
        b1 = b.pow(n);
        v = a1.subtract(b1);
        if(v.compareTo(c) >0 || v.compareTo(c)==0){
            System.out.println("bigger");
        }
        else{
            System.out.println("smaller");
        }
    }

    void calculate(){
        fillParams();
        count();
    }

}
