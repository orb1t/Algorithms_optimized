import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Jerry on 12-04-2017.
 */
public class SimilarDishes {
    public static void main(String[] args) throws IOException {


        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(in.readLine());

        for (int i = 0; i < count; i++) {
            int sameDishCount = 0;
            Set<String> set = new HashSet<>();
            String line1 = in.readLine();
            String[] str1 = line1.split(" ");
            for (String s : str1) {
                set.add(s);
            }
            String line2 = in.readLine();
            String[] str2 = line2.split(" ");
            for (String s : str2) {
                if (set.contains(s))
                    sameDishCount++;
            }

            int length = str1.length;
            if(length % 2 == 0 && sameDishCount >= (length/2))
                System.out.println("similar");
            else if (length % 2 == 1 && sameDishCount >= (length/2)+1)
                System.out.println("similar");

            else
                System.out.println("dissimilar");


        }

    }

}
