package KAKAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] key = new int[N][N];
        int[][] lock = new int[M][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                key[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                lock[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int extend = lock.length + (key.length - 1)*2;
        int success = 0;
        int rotateCount = 4;
        while(rotateCount-- >0){

            for(int i = 0; i < extend-2; i++) {
                for (int j = 0; j < extend - 2; j++) {

                    int[][] extendArray = new int[extend][extend];

                    int x = key.length - 1;
                    for (int k = 0; k < lock.length; k++) {
                        int y = key.length - 1;
                        for (int o = 0; o < lock.length; o++) {
                            extendArray[x][y] = lock[k][o];
                            y++;
                        }
                        x++;
                    }

                    int z = i;
                    for (int k = 0; k < key.length; k++) {
                        int y = j;
                        for (int o = 0; o < key.length; o++) {

                            extendArray[z][y] += key[k][o];

                            y++;
                        }
                        x++;
                    }

                    for (int k = key.length - 1; k < extend - (key.length - 1); k++) {
                        for (int o = key.length - 1; o < extend - (key.length - 1); o++) {
                            if (extendArray[k][k] == extendArray[k][o]) {
                                success++;
                            }
                        }
                    }

                    if (success == lock.length * lock.length) {
                        break;
                    }else {
                        success = 0;
                    }

                }
                if (success == lock.length * lock.length) {
                    break;
                }
            }

            if(success == lock.length * lock.length){
                System.out.println("Success");
                break;
            }

            rotateRight(key);

        }
        if(success == 0){
            System.out.println("fail");
        }

    }

    public static int[][] rotateRight(int[][] array){
        int[][] right = new int[array.length][array.length];
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length; j++){
                right[i][j] = array[array.length-1-j][i];
            }
        }
        return right;
    }
}
