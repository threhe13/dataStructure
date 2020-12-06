package SecretSentence1228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> list = new LinkedList<Integer>();
        StringTokenizer sz;

        for(int j = 0; j < 10; j++) {
            int Number = Integer.parseInt(br.readLine());
            sz = new StringTokenizer(br.readLine());

            for (int i = 0; i < Number; i++) {
                list.add(Integer.parseInt(sz.nextToken()));
            }

            int repeat = Integer.parseInt(br.readLine());
            sz = new StringTokenizer(br.readLine());
            for (int i = 0; i < repeat; i++) {
                String a = sz.nextToken();
                int input = Integer.parseInt(sz.nextToken());
                if (a.equals("I")) {
                    int count = Integer.parseInt(sz.nextToken());
                    while (count-- > 0) {
                        list.add(input++, Integer.parseInt(sz.nextToken()));
                    }
                }
                else if(a.equals("D")){
                    int count = Integer.parseInt(sz.nextToken());
                    while(count-- > 0){
                        list.remove(input);
                    }
                }
                else if(a.equals("A")){
                    while(input-- > 0) {
                        list.addLast(Integer.parseInt(sz.nextToken()));
                    }
                }
            }
            System.out.print("#"+(j+1)+" ");
            for (int i = 0; i < 10; i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
            list.clear();
        }
    }
}
