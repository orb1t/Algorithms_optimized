/**
 * Created by Jerry on 15-08-2017.
 */
public class FastExponent {

    public static double getExponent(double x,long n){

 n = Math.abs((n));
        if(n==0 || x == 1)
            return 1;
        if(n==1)
            return x;
        if(n<0){
            return getExponent(1/x,-n);
        }
        if((n&1)!=0) // odd
            return x * getExponent(x,n-1);
        else // even
            return  getExponent(x*x,n>>2) ;


    }

    public static void main(String[] args) {
        double exponent = getExponent(2.00000, -2147483648);
        System.out.println("answer is "+exponent);
    }

}
