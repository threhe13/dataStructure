package HideAndSeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] distance;//길이 배열
    static boolean[] isVisit;
    static int subin;//수빈의 위치
    static int brother;//동생의 위치

    static final int size = 100001;

    static int[] isMove = {1, -1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //위치 입력
        subin = Integer.parseInt(st.nextToken());
        brother = Integer.parseInt(st.nextToken());

        //배열크기 입력
        distance = new int[size];
        isVisit = new boolean[size];

        //BFS 실행
        BFS();
    }

    static void BFS(){
        Queue<Integer> que = new LinkedList<Integer>();
        //수빈의 위치 입력
        que.offer(subin);
        //방문기록 true
        isVisit[subin] = true;

        while(!que.isEmpty()){
            //시작점 저장
            int start = que.poll();
            //목표 정의
            int goal = 0;

            for(int i = 0; i < isMove.length; i++){
                //위치에 따라 목표값 변화
                if(i == 2){
                    goal = start * 2;
                }
                else{
                    goal = start + isMove[i];
                }

                //방문한 적이 없고 목표가 배열의 크기 안에 있는 경우
                if(goal >= 0 && goal < size && !isVisit[goal]){
                    //목표위치 방문기록 true
                    isVisit[goal] = true;
                    //몇 번째 만에 도착했는지 배열에 저장
                    distance[goal] = distance[start] + 1;
                    //다시 큐에 넣어서 재생을 기다림
                    que.offer(goal);
                    //만약 목표가 동생의 위치랑 같으면 반복문 종료
                    if(goal == brother){
                        break;
                    }
                }
            }
        }

        //동생위치에 저장된 횟수 출력 
        System.out.println(distance[brother]);

    }
}
