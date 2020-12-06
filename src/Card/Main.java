package Card;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int CardNumber = Integer.parseInt(br.readLine());

        Queue<Integer> que = new LinkedList<Integer>();

        for(int i = 1; i <= CardNumber; i++){
            que.offer(i);
        }

        while(CardNumber-- > 1){
            que.poll();
            if(que.size() != 1) {
                que.offer(que.poll());
            }
        }

        System.out.println(que.peek());
    }
}
