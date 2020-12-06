package View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int test_case = 0; test_case < 10; test_case++){
            int repeat = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            int[] building = new int[repeat];
            for(int i = 0; i < repeat; i++){
                building[i] = Integer.parseInt(str[i]);
            }
            int result = 0;
            for(int i = 2; i < repeat - 2; i++){
                int[] array = new int[4];
                array[0] = building[i-2];
                array[1] = building[i-1];
                array[2] = building[i+1];
                array[3] = building[i+2];
                Arrays.sort(array);
                if(building[i] > array[3]){
                    result += (building[i] - array[3]);
                }
            }
            System.out.println("#"+(test_case+1)+" "+result);
        }
    }
}
