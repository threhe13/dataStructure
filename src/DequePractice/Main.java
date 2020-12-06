package DequePractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Repeat = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<Integer>();

        for(int testCase = 0; testCase < Repeat; testCase++){

            String[] str = br.readLine().split(" ");

            if(str[0].equals("push_front")){
                int input = Integer.parseInt(str[1]);
                deque.addFirst(input);
            }
            else if(str[0].equals("push_back")){
                int input = Integer.parseInt(str[1]);
                deque.addLast(input);
            }
            else if(str[0].equals("pop_front")){
                System.out.println(deque.isEmpty() ?  -1 : deque.removeFirst());
            }
            else if(str[0].equals("pop_back")){
                System.out.println(deque.isEmpty() ? -1 : deque.removeLast());
            }
            else if(str[0].equals("size")){
                System.out.println(deque.size());
            }
            else if(str[0].equals("empty")){
                System.out.println(deque.isEmpty() ? 1 : 0);
            }
            else if(str[0].equals("front")){
                System.out.println(deque.isEmpty() ? -1 : deque.peekFirst());
            }
            else if(str[0].equals("back")){
                System.out.println(deque.isEmpty() ? -1 : deque.peekLast());
            }

        }
    }
}
