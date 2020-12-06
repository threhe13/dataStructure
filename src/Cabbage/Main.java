package Cabbage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] farm;
    static int length;
    static int width;
    static int Number;

    static boolean[][] check;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int count;

    static class location{
        int x;
        int y;
        public location(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static void BFS(int x, int y){
        Queue<location> que = new LinkedList<location>();

        que.offer(new location(x, y));

        while(!que.isEmpty()){

            location location = que.poll();
            check[location.x][location.y] = true;

            for(int i = 0; i < dx.length; i++){
                int nx = location.x + dx[i];
                int ny = location.y + dy[i];

                if(nx >= 0 && nx < length && ny >= 0 && ny < width){
                    if(farm[nx][ny] == 1 && !check[nx][ny]){
                        que.offer(new location(nx, ny));
                        check[nx][ny] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int Test_Case = Integer.parseInt(st.nextToken());

        for(int test = 0; test < Test_Case; test++){

            count = 0;

            st = new StringTokenizer(br.readLine());
            width = Integer.parseInt(st.nextToken());
            length = Integer.parseInt(st.nextToken());
            Number = Integer.parseInt(st.nextToken());

            farm = new int[length][width];
            check = new boolean[length][width];

            for(int i = 0; i < Number; i++){
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());

                farm[x][y] = 1;
            }

            for(int i = 0; i < length; i++){
                for(int j = 0; j < width; j++){
                    if(farm[i][j] == 1 && !check[i][j]){
                        BFS(i, j);
                        count++;
                    }
                }
            }

            System.out.println(count);

        }
    }
}
