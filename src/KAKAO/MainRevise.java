package KAKAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MainRevise {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] key = new int[N][N];
        int[][] lock = new int[M][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                key[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                lock[M][M] = Integer.parseInt(st.nextToken());
            }
        }
        solution s = new solution();
        boolean check = s.solution(key, lock);
        if(check) System.out.println("Success");
        else System.out.println("Fail");
    }
}

class solution{

    private int extend;
    private int center;
    private int end;

    public boolean solution(int[][] key, int[][] lock){
        int lockSize = lock.length;

        center = key.length - 1;
        end = center + lockSize;
        extend = lock.length + (center*2);

        int rotateCount = 4;
        //회전 기회 4번
        while(rotateCount-- > 0){

            //5*5 모든 경우 검사
            for(int i = 0; i < end; i++){
                for(int j = 0; j < end; j++){
                    if(isUnlock(lock, key, i, j)){
                        return true;
                    }
                }
            }

        }
        return false;
    }

    boolean isUnlock(int[][] lock, int[][] key, int startA, int startB){
        int[][] extendArray = new int[extend][extend];

        int resultCount = 0;
        //생성한 2차원 배열에 키 값의 크기만큼 저장
        for(int i = 0; i < key.length; i++){
            for(int j = 0; j < key.length; j++){
                extendArray[i+startA][j+startB] = key[i][j];
            }
        }
        //중앙에 자물쇠값 저장
        for(int i = center; i < end; i++){
            for(int j = center; j < end; j++){
                extendArray[i][j] += lock[i-center][j-center];
            }
        }
        //자물쇠 모든 수 검사(동일성검사)
        for(int i = center; i < end; i++){
            for(int j = center; j < end; j++){
                if(extendArray[i][i] == extendArray[i][j]){
                    resultCount++;
                }
            }
        }
        //자물쇠의 모든 수가 동일하면 true, 아니면 false
        if(resultCount == lock.length*lock.length) {
            return true;
        }
        else return false;
    }

    int[][] turnRight(int[][] key){
        int[][] right = new int[key.length][key.length];
        for(int i = 0; i < key.length; i++){
            for(int j = 0; j < key.length; j++){
                right[i][j] = key[key.length-1-j][i];
            }
        }
        return right;
    }

}
