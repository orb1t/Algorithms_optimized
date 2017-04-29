import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Prit Sheth on 12-04-2017.
 */
public class BearAndRow01 {
    public static void main(String[] args) throws IOException {


        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(in.readLine());

        for (int i = 0; i < count; i++) {
            String data = in.readLine();
//            System.out.println(getMaxCost(data));
            System.out.println(getTime(data));
        }

    }

    public static long getTime(String data) {
        long cost = 0;
        long dist = 0;
        char[] chars = data.toCharArray();
        int len = chars.length;
        int totalOne = 0;
        for (int i = 0; i < len; i++) {
           /* if (i - 1 >= 0 && chars[i] == '0' && chars[i - 1] == '1') {
                dist += totalOne;
            }
*/
            if(i == len-1 && chars[i] == '0')
                dist += totalOne;
            else if(chars[i] == '0' && chars[i+1]=='1'){
                dist += totalOne;
            }

            if (chars[i] == '1')
                totalOne++;
            else
                cost += totalOne;
        }
        // System.out.println("1st"+cost);

        // System.out.println("dist "+dist);

        return cost + dist;
    }

/*
    public static int getMaxCost(String data) {
        int cost = 0;
        char[] chars = data.toCharArray();
        int len = chars.length;
        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1')
                set.add(i);
        }

        boolean flag = isAllOneTogether(set, len);
        while (!flag) {
            int firstOne = set.first();
            cost += getFirstOneFromSet(set, firstOne, len);
            flag = isAllOneTogether(set, len);
        }
        return cost;
    }

    public static int getFirstOneFromSet(TreeSet<Integer> set, int i, int len) {
        if (i == len - 1) return 0;

        // if last one -- 000100000000000 have to swap with last 0
        if (i == set.last()) {
            set.remove(i);
            set.add(len - 1);
            return len - 1 - i + 1;
        }

        int index = set.higher(i);
        //"111100000" for  consecutive 1
        if (i + 1 == index)
            return getFirstOneFromSet(set, index, len);

        set.remove(i);
        set.add(index - 1);
        return index - i;
    }

    public static boolean isAllOneTogether(TreeSet<Integer> set, int len) {
        return (set.last() - set.first() + 1 == set.size() && set.last() == len - 1);
    }*/
}
