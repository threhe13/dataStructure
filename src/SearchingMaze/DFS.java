package SearchingMaze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DFS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        //정점의 개수
        int N = Integer.parseInt(str[0]);
        //간선의 개수
        int E = Integer.parseInt(str[1]);
        //탐색을 시작하는 정점의 번호
        int start = Integer.parseInt(str[2]);

        int[][] Graph = new int[N+1][N+1];

        for(int i = 0; i < E; i++){
            String[] input = br.readLine().split(" ");
            int v1 = Integer.parseInt(input[0]);
            int v2 = Integer.parseInt(input[1]);

            Graph[v1][v2] = 1;
            Graph[v2][v1] = 1;
        }

    }
    //스택을 이용한 DFS
    public static void StackDFS(int[][] Graph, int v, boolean[] c, boolean flag){
        Stack<Integer> stack = new Stack<Integer>();
        //Graph가 인접행렬
        int n = Graph.length - 1;

        //탐색 시작 정점 번호를 스택에 저장
        stack.push(v);
        //길찾기 가능을 보여줌(방문여부)
        c[v] = true;
        System.out.print(v+" ");

        while(!stack.isEmpty()){
            int vv = stack.peek();

            flag = false;

            for(int i = 1; i <= n; i++){
                //방문한 적이 없고, 탐색 시작하는 행렬의 위치에서
                if(Graph[vv][i] == 1 && !c[i]){
                    stack.push(i);
                    System.out.print(i+" ");
                    //방문한 적이 있는 위치는 boolean을 이용해 표시
                    c[i] = true;
                    flag = true;
                    break;
                }
            }
            //검색을 다 한 후 반복되는 과정을 빠져나오기 위해 pop을 이용
            if(!flag){
                stack.pop();
            }
        }

    }
    //재귀를 이용한 DFS - 잘 모르겠는데...?
    public static void ReturnDFS(int[][] Graph, boolean[] c, int v){
        //길이 저장
        int n = Graph.length - 1;
        //탐색 시작 지점에 방문한 적이 있다는 것을 표시
        c[v] = true;
        System.out.print(v+" ");

        for(int i = 1; i <= n; i++){

            if(Graph[v][i] == 1 && !c[i]){
                ReturnDFS(Graph, c, i);
            }
        }

    }
    //BFS는 큐를 사용한다!
    public static void QueueBFS(int[][] Graph, int v, boolean[] c){
        Queue<Integer> queue = new LinkedList<>();
        int n = Graph.length - 1;
        //출발지점 저장
        queue.add(v);
        c[v] = true;

        while(!queue.isEmpty()){

            v = queue.poll();
            System.out.print(v+" ");

            for(int i = 1; i <= n; i++){

                if(Graph[v][i] == 1 && !c[i]){
                    queue.add(i);
                    c[i] = true;
                }
            }


        }

    }


}
