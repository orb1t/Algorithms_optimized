import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Jerry on 12-04-2017.
 */
public class DishLife {
    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(in.readLine());

        for (int i = 0; i < count; i++) {
            String answer = getAnswer(in);
            System.out.println(answer);
        }

    }

    private static String getAnswer(BufferedReader in) throws IOException {


        //Taking N,K
        String line1 = in.readLine();
        String[] str1 = line1.split(" ");
        int N = Integer.valueOf(str1[0]);
        int K = Integer.valueOf(str1[1]);
        Set<String> set = new HashSet<>();
        while (N > 0) {
            if (set.size() == K) {
                while(N-->0)
                    in.readLine();
                return "some";
            }
            String line2 = in.readLine();
            String[] str2 = line2.split(" ");
            for (int j = 1; j < str2.length; j++) {
                set.add(str2[j]);
            }
            N--;
        }
        if (set.size() == K)
            return "all";

        else
            return "sad";


    }



}
