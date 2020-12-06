package Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        Queue<Integer> queue = new LinkedList<Integer>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int repeat = Integer.parseInt(br.readLine());
        for(int i = 0; i < repeat; i++){
            String[] str = br.readLine().split(" ");
            int input = -1;

            if(str[0].equals("push")){
                input = Integer.parseInt(str[1]);
                queue.offer(input);
            }
            else if(str[0].equals("front")){
                System.out.println(queue.isEmpty() ? -1 : queue.peek());
            }
            else if(str[0].equals("back")){
                System.out.println(queue.isEmpty() ? -1 : input);
            }
            else if(str[0].equals("size")){
                System.out.println(queue.size());
            }
            else if(str[0].equals("empty")){
                System.out.println(queue.isEmpty() ? -1 : 0);
            }
            else if(str[0].equals("pop")){
                System.out.println(queue.isEmpty() ? -1 : queue.poll());
            }
        }
    }
}
