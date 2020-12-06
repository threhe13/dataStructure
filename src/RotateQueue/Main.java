package RotateQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //첫번째 줄 입력
        st = new StringTokenizer(br.readLine());
        int Number = Integer.parseInt(st.nextToken());
        int rotateNumber = Integer.parseInt(st.nextToken());

        //덱 정의
        Deque<Integer> deque = new ArrayDeque<Integer>();
        //덱에 자연수 넣기
        for(int test = 1; test <= Number; test++){
            deque.addLast(test);
        }
        //두번째 줄 입력
        st = new StringTokenizer(br.readLine());
        int[] Wants = new int[rotateNumber];
        //이동 횟수 계산
        int count = 0;
        //회전 횟수만큼 반복하기
        for(int i = 0; i < rotateNumber; i++){
            //원하는 값 입력
            Wants[i] = Integer.parseInt(st.nextToken());

            int check = checkLength(deque, Wants[i]);

            if(check == 1){
                while(Wants[i] != deque.peekFirst()){
                    deque.addLast(deque.pollFirst());
                    count++;
                }
                deque.removeFirst();
            }
            else if(check == 2){
                while(Wants[i] != deque.peekLast()){
                    deque.offerFirst(deque.removeLast());
                    count++;
                }
                deque.removeLast();
                count++;
            }
            else{
                while(Wants[i] != deque.peekFirst()){
                    deque.addLast(deque.pollFirst());
                    count++;
                }
                deque.removeFirst();
            }
        }
        System.out.println(count);
    }

    static int checkLength(Deque<Integer> deque, int Wants){
        Iterator it = deque.iterator();
        int length = deque.size();
        int cnt = 0;
        int want = 0;
        while(it.hasNext()){
            if(want  == Wants){
                break;
            }
            want = (Integer) it.next();
            cnt++;
        }
        //전체 길이가 짝수인 경우
        if(length%2 == 0) {
            //중앙에서 왼쪽에 위치할 때
            if(cnt <= length/2){
                return 1;
            }
            //중앙에서 오른쪽에 위치할 때
            else{
                return 2;
            }
        }
        //전체 길이가 홀수인 경우
        else{
            //중앙에서 왼쪽에 위치할 때
            if(cnt <= length/2){
                return 1;
            }
            //중앙에서 오른쪽에 위치할 때
            else if(cnt > (length/2)+1){
                return 2;
            }
            //가운데에 있을 때
            else{
                return 0;
            }
        }
    }

}
