import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

/**
 * Created by Prit Sheth on 11-04-2017.
 */
public class Main {


    public static void main(String[] args) throws IOException {


        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(in.readLine());

        String answers[] = new String[count];

        for (int i = 0; i < count; i++) {
            answers[i] = getPostfix(in.readLine());
        }
    }



  public  static  boolean  isOperator(char c)
    {
        if(c == '+' || c == '-' || c == '*' || c == '/')
            return true;
        return false;
    }

    

    public static String getPostfix(String inputPrefix){
        char[] prefix = inputPrefix.toCharArray();
        Stack<String> st = new Stack<>();
        String postfix = "";
        String top1,top2="";
        for (int i = prefix.length -1; i >= 0 ; i--) {


            if (isOperator(prefix[i]))
            {
                top1 = st.peek();
                st.pop();
                top2 = st.peek();
                st.pop();

                top2 += prefix[i];
                st.push(top1 + top2);
            }
            else
            {
                top1 = "";
                top1 += prefix[i];
                st.push(top1);
            }
        }

         postfix = st.peek();
        st.pop();
       return postfix;
    }
        



    public static int getMaxCost(String data) {
        int cost = 0;
        char[] chars = data.toCharArray();

        int firstOne = 0;
        while (firstOne != -1) {
            firstOne = getFirstOne(chars);
            if (firstOne == -1) return cost;
            for (int i = firstOne; i < chars.length - 1; i++) {
                if (chars[i] == '1' && chars[i + 1] != '1') {
                    cost += swapAndCount(chars, i);
                }
            }
        }
        return cost;
    }

    public static void swap(char[] data, int i, int j) {
        char temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    //If next is not one
    public static int getNextOne(char data[], int index) {
        for (int i = index; i < data.length - 1; i++) {
            if (data[i] == '0' && data[i + 1] == '1')
                return i;
            else if (i + 1 == data.length - 1 && data[i + 1] == '0')
                return i + 1;
        }
        return -1;
    }

    public static int swapAndCount(char data[], int index) {
        int beforeOne = getNextOne(data, index);
        if (beforeOne == -1)
            return 0;
        swap(data, index, beforeOne);
        return beforeOne - index + 1;
    }

    public static int getFirstOne(char data[]) {
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i] == '1' && data[i + 1] == '0') return i;
        }
        return -1;
    }


}
/**
 *
 */