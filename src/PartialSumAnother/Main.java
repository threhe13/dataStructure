package PartialSumAnother;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long S = Long.parseLong(st.nextToken());

        long[] array = new long[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        long min = Long.MAX_VALUE;

        while(right < N){
            long count = 0;

            for(int i = left; i <= right; i++){
                count += array[i];
            }

            if(count >= S){
                int result = right-left+1;
                if(min > result){
                    min = result;
                }
                left++;
            }
            else{
                right++;
            }
        }

        if(min <= N) {
            System.out.println(min);
        }
        else{
            System.out.println("0");
        }
    }
}
