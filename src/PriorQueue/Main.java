package PriorQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int Test_case = Integer.parseInt(st.nextToken());

        for(int test = 0; test < Test_case; test++){
            st = new StringTokenizer(br.readLine());
            int DocNumber = Integer.parseInt(st.nextToken());
            int choiceDoc = Integer.parseInt(st.nextToken());

            Queue<Document> que = new LinkedList<Document>();

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < DocNumber; i++){
                int input = Integer.parseInt(st.nextToken());
                que.add(new Document(i, input));
            }

            int result = 1;

            while(!que.isEmpty()){
                Document current = que.poll();
                boolean check = true;

                Iterator it = que.iterator();//반복자를 활용잘해보자! 
                while(it.hasNext()){
                    Document value = (Document) it.next();
                    if(current.DocPrior < value.DocPrior){
                        check = false;
                        break;
                    }
                }

                if(check == false){
                    que.add(current);
                }
                else{
                    if(current.DocNumber == choiceDoc){
                        System.out.println(result);
                    }
                    else {
                        result++;
                    }
                }
            }

        }

    }
}

class Document{
    int DocNumber;
    int DocPrior;

    public Document(int docNumber, int docPrior){
        this.DocNumber = docNumber;
        this.DocPrior = docPrior;
    }
}

