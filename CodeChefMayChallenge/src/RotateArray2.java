/**
 * Created by Jerry on 13-05-2017.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class RotateArray2 {
/**
 * Created by psheth on 5/12/2017.
 */
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] split = bufferedReader.readLine().split(" ");
        int N = Integer.valueOf(split[0]);
        int K = Integer.valueOf(split[1]);
        int P = Integer.valueOf(split[2]);
        Integer data[] = new Integer[N];

        Map<Integer, Integer> map = new HashMap<>();
        String[] inputs = bufferedReader.readLine().split(" ");
        String inputString = "";
        for (int i = 0; i < N; i++) {
            Integer integer = Integer.valueOf(inputs[i]);
            data[i] = integer;
            inputString += integer;
        }

        String query = bufferedReader.readLine();

        int totalCount = 0;
        for (int i = 0; i < P; i++) {

            if (query.charAt(i) != '?') {
                totalCount++;
            }

        }



        updateMap(data, K, map, 0,totalCount);
        updateMap(data, K, map, data.length - 1,totalCount);

        totalCount = 0;
        for (int i = 0; i < P; i++) {

            if (query.charAt(i) == '?') {
                int key = totalCount % data.length;
                if(key == 0)
                    key = data.length;
                Integer value = map.get(key);
                System.out.println(value);

            } else {
                totalCount++;
            }

        }

    }
/*
    private static void rotateArray(int[] data, int i) {
        int last = data[data.length - 1];
        int temp = 0;
        for (int j = 0; j < data.length; j++) {
            temp = data[j];
            data[j] = last;
            last = temp;
        }
    }
*/

  /*  private static String rotateArray(String input, int i) {
        char[] data = input.toCharArray();
        char last = data[data.length - 1];
        char temp = ' ';
        for (int j = 0; j < data.length; j++) {
            temp = data[j];
            data[j] = last;
            last = temp;
        }

        input = new String(data);
        return input;
    }*/

    private static int getMax(Integer data[], int K, Map<Integer, Integer> map) {
        int max = 0;
        for (int i = 0; i < K; i++) {

            if (data[i] == 1)
                max++;

        }

        if (max == K)
            return K;
        int maximum = max;
        for (int i = K; i < data.length; i++) {
            if (data[i - K] == 1)
                max--;
            if (data[i] == 1)
                max++;
            if (maximum < max) {
                maximum = max;
            }
            if (maximum == K)
                return K;
        }
        map.put(0, maximum);
        return maximum;
    }

    private static void updateMap(Integer data[], int K, Map<Integer, Integer> map, int startIndex, int counter) {

        if (startIndex < 0 || counter ==0)
            return;

        int loopIndex = startIndex;
        int tempK = K;
        int tempMax = 0;

        while (tempK-- > 0) {
            if (loopIndex == data.length)
                loopIndex = 0;

            if (data[loopIndex] == 1)
                tempMax++;
            loopIndex++;
        }

        if (tempMax == K) {
            map.put(data.length - startIndex, K);
            updateMap(data, K, map, --startIndex,--counter);
            return;
        }

        if (loopIndex == data.length)
            loopIndex = 0;
        int maximum = tempMax;

        while (loopIndex != startIndex) {

            if (loopIndex == data.length)
                loopIndex = 0;

            int updatedIndex = loopIndex - K;
            if (updatedIndex < 0)
                updatedIndex = data.length + updatedIndex;

            if (data[updatedIndex] == 1)
                tempMax--;
            if (data[loopIndex] == 1)
                tempMax++;
            if (maximum < tempMax) {
                maximum = tempMax;
            }
            if (maximum == K) {
                map.put(data.length - startIndex, K);
                updateMap(data, K, map, --startIndex,--counter);
                return;
            }

            loopIndex++;
        }

        map.put(data.length - startIndex, maximum);
        updateMap(data, K, map, --startIndex,--counter);
    }



/*

    private static int getMaxForString(String inputs, int K) {
        char[] data = inputs.toCharArray();
        int max = 0;
        for (int i = 0; i < K; i++) {

            if (data[i] == '1')
                max++;

        }
        if(max == K)
            return K;
        int maximum = max;
        for (int i = K; i < data.length; i++) {
            if (data[i - K] == '1')
                max--;
            if (data[i] == '1')
                max++;
            if (maximum < max) {
                maximum = max;
            }
            if(maximum == K)
                return K;
        }

        return maximum;
    }
*/

}