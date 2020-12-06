package HowManyNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static final int Students = 101;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int test_case = Integer.parseInt(br.readLine());
        for(int i = 0; i < test_case; i++){
            int[] test_score = new int[Students];
            int test_Number = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int count = 1000;
            while(count-- > 0){
                int score = Integer.parseInt(st.nextToken());
                test_score[score]++;
            }
            int max = 0;
            int result = 0;
            for(int j = 0; j < Students; j++){
                if(test_score[j] >= max){
                    max = test_score[j];
                    result = j;
                }
            }
            System.out.print("#"+test_Number+" "+result);
            System.out.println();
        }
    }
}
