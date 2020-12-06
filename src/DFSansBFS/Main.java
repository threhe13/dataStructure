package DFSansBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static boolean[] isVisit;
    static int N;
    static int E;
    static int start;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        arr = new int[N+1][N+1];
        isVisit = new boolean[N+1];

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y] = 1;
            arr[y][x] = 1;
        }

        BFS(start);
    }

    static void BFS(int input){
        Queue<Integer> que = new LinkedList<Integer>();
        que.offer(input);
        isVisit[input] = true;

        while(!que.isEmpty()){
            int temp = que.poll();
            System.out.print(temp + " ");

            for(int i = 1; i <= N; i++){
                if(arr[temp][i] == 1 && isVisit[i] == false){
                    que.offer(i);
                    isVisit[i] = true;
                }
            }
        }
    }
}
