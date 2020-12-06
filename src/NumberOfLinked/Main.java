package NumberOfLinked;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, E;

    static int[] c;
    static int[][] Graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //정점의 개수
        E = Integer.parseInt(st.nextToken()); //간선의 개수

        Graph = new int[N+1][N+1];
        c = new int[N+1];

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            Graph[v1][v2] = 1;
            Graph[v2][v1] = 1;
        }

        int count = 1;
        for(int i = 1; i <= N; i++){
            if(c[i] == 0){
                DFS(i, count);
                count++;
            }
        }
        System.out.println(count-1);

    }

    static void DFS(int x, int count){
        c[x] = count;
        for(int i = 1; i < Graph.length; i++){
            if(Graph[x][i] == 1 && c[i] == 0){
                DFS(i, count);
            }
        }
    }
}

