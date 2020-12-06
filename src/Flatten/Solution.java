package Flatten;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    static final int width = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int test_case = 0; test_case < 10; test_case++) {
            int dumpNumber = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            int[] block = new int[width];
            for(int i = 0; i < width; i++){
                block[i] = Integer.parseInt(str[i]);
            }
            int length = 100;
            Arrays.sort(block);
            while(dumpNumber-- > 0){
                block[width-1]--;
                block[0]++;
                Arrays.sort(block);
            }
            int result = (block[width-1]-block[0]);
            System.out.println("#"+(test_case+1)+" "+result);
        }
    }
}
