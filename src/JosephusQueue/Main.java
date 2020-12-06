package JosephusQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder("<");

        int Member = Integer.parseInt(st.nextToken());
        int removeNumber = Integer.parseInt(st.nextToken());

        Queue<Integer> que = new LinkedList<Integer>();

        for(int i = 1; i <= Member; i++){
            que.offer(i);
        }

        while(Member-- > 0){

            for(int i = 1; i < removeNumber; i++){
                que.offer(que.poll());
            }

            sb.append(que.poll()+", ");

        }

        System.out.println(sb.substring(0, sb.length()-2) + ">");

    }
}
