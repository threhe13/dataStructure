package SearchingMaze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] maze;
    static int length;
    static int width;
    static boolean[][] isVisit;
    static int[][] result;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static class coordinate{
        int x;
        int y;
        int count;
        public coordinate(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    static void BFS(){
        Queue<coordinate> que = new LinkedList<coordinate>();
        que.offer(new coordinate(0, 0, 1));
        int count = 0;

        while(!que.isEmpty()){

            coordinate co = que.poll();
            isVisit[co.x][co.y] = true;
            count = co.count;

            for(int i = 0; i < dx.length; i++){
                int nx = co.x + dx[i];
                int ny = co.y + dy[i];

                if(0 <= nx && nx < length && ny >= 0 && ny < width){
                    if(maze[nx][ny] == 1 && !isVisit[nx][ny]){
                        que.offer(new coordinate(nx, ny, count + 1));
                        isVisit[nx][ny] = true;
                    }
                }

                if(isVisit[length-1][width-1]){
                    break;
                }

            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        length = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());

        maze = new int[length][width];
        isVisit = new boolean[length][width];
        result = new int[length][width];

        //배열 입력
        for(int i = 0; i < length; i++){
            String str = br.readLine();
            for(int k = 0; k < width; k++){
                int input = str.charAt(k) - '0';
                maze[i][k] = input;
            }
        }

        BFS();
    }
}
