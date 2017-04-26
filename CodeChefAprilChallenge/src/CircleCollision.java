import java.util.Scanner;

/**
 * Created by Jerry on 16-04-2017.
 */
public class CircleCollision {

    long preSum[];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] r = new int[n];
        for(int r_i=0; r_i < n; r_i++){
            r[r_i] = in.nextInt();
        }
        // Write Your Code Here



    }


    public long getArea(int r){
        return (22/7)*r*r;
    }

}
