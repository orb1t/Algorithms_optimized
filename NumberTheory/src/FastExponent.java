/**
 * Created by Jerry on 15-08-2017.
 */
public class FastExponent {

    public static double getExponent(double x,int n){


         if(n==1)
            return x;
        //x^n = x*(x^2)^n/2
        if((n&1) != 0)// odd
        {
           return  x*(getExponent(x,n-1));
        }
        else{
            return  (getExponent(x*x,n/2));

        }


    }

    public static void main(String[] args) {
//        int exponent = getExponent(4, 4);
//        System.out.println("answer is "+exponent);
    }

}
