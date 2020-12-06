package PriorQueuePractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int Test_Case = Integer.parseInt(st.nextToken());

        for(int test = 0; test < Test_Case; test++){
            st = new StringTokenizer(br.readLine());

            int DocNumber = Integer.parseInt(st.nextToken());
            int Wants = Integer.parseInt(st.nextToken());

            Queue<Paper> que = new LinkedList<Paper>();

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < DocNumber; i++){
                int input = Integer.parseInt(st.nextToken());
                que.offer(new Paper(i, input));
            }


            int result = 1;

            while(!que.isEmpty()){
                Paper case1 = que.poll();
                Iterator it = que.iterator();

                boolean check = true;

                while(it.hasNext()){
                    Paper case2 = (Paper) it.next();
                    if(case1.Prior < case2.Prior){
                        check = false;
                        break;
                    }
                }

                if(!check){
                    que.offer(case1);
                }
                else {
                    if(case1.Number == Wants){
                        System.out.println(result);
                    }
                    else{
                        result++;
                    }
                }


            }

        }

    }
}

class Paper{
    int Number;
    int Prior;

    public Paper(int number, int prior){
        this.Number = number;
        this.Prior = prior;
    }
}
