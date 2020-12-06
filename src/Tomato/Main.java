package Tomato;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int width;
    static int length;
    static int[][] farm;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        width = Integer.parseInt(st.nextToken());
        length = Integer.parseInt(st.nextToken());

        farm = new int[length+1][width+1];
        //주어진 배열 입력
        for(int i = 1; i <= length; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= width; j++){
                farm[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        BFS();


    }

    static boolean checkTomato(){
        for(int i = 1; i <= length; i++){
            for(int j = 1; j <= width; j++){
                if(farm[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }

    static void BFS(){
        Queue<Tomato> que = new LinkedList<Tomato>();
        int day = 0;

        for(int i = 1; i <= length; i++){
            for(int j = 1; j <= width; j++){
                if(farm[i][j] == 1){
                    que.offer(new Tomato(i, j, 0));
                }
            }
        }

        while(!que.isEmpty()){
            Tomato tomato = que.poll();
            day = tomato.day;

            for(int i = 0; i < dx.length; i++){
                int nx = tomato.x + dx[i];
                int ny = tomato.y + dy[i];

                if(1 <= nx && nx <= length && 1 <= ny && ny <= width){
                    if(farm[nx][ny] == 0){
                        farm[nx][ny] = 1;
                        que.offer(new Tomato(nx, ny, day+1));
                    }
                }

            }
        }

        if(checkTomato()){
            System.out.println(day);
        }
        else{
            System.out.println(-1);
        }
    }
}

class Tomato{

    int x;
    int y;
    int day;

    public Tomato(int x, int y, int day){
        this.x = x;
        this.y = y;
        this.day = day;
    }
}
