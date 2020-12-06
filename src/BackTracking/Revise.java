package BackTracking;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

public class Revise {
    private static Stack<Pos> posStack = new Stack<>();
    private static Map<Pos, Boolean> visitHistory = new HashMap<>();

    // 0은 벽, 1은 통로, 2는 출구
    private static int[][] mazeArr = {
            {1, 0, 0, 0},
            {1, 1, 1, 0},
            {0, 1, 0, 0},
            {0, 1, 1, 1},
            {0, 2, 0, 0}
    };


    // 시계방향으로 이동가능한지 확인을 위함
    private static int[][] directionArr = {
            {1, 0}, // 우
            {0, 1}, // 하
            {-1, 0}, // 좌
            {0, -1} // 상
    };

    public static void main(String[] args) {
        Pos now = new Pos(0, 0);
        posStack.push(now);

        do {
            System.out.println(now);
            visitHistory.put(now, true);

            Pos movablePos = move(now);
            if(movablePos != null) {
                posStack.push(movablePos);
            } else {
                movablePos = posStack.pop();
            }
            now = movablePos;
        } while(mazeArr[now.getY()][now.getX()] != 2);
    }

    /**
     * 이동할 수 있는 위치 반환. 이동할 수 없다면 null 반환
     * @param pos
     * @return
     */
    private static Pos move(Pos pos) {
        int x = pos.getX();
        int y = pos.getY();

        // 현재위치에서 시계방향으로 이동할 수 있는 곳을 체크함
        for(int i=0; i<4; i++) {
            int[] direction = directionArr[i];
            int moveX = direction[0];
            int moveY = direction[1];

            // 미로 범위안에서 이동가능 체크
            if((x + moveX) >= 0 && (x + moveX) <= 3
                    && (y + moveY) >= 0 && (y + moveY) <= 4) {
                if(mazeArr[y+moveY][x+moveX] == 0) {
                    continue;
                }
                // 1(통로) 아니면 2(도착지)
                Pos movePos = new Pos(x+moveX, y+moveY);

                boolean isVisit = posStack.contains(movePos);
                if(!isVisit) {
                    Boolean hasVisitHisotry = visitHistory.get(movePos);
                    if(hasVisitHisotry == null) {
                        return movePos;
                    }
                }
            }
        }
        return null;
    }
}


class Pos {
    private int x;
    private int y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null || !(obj instanceof Pos)) {
            return false;
        }
        Pos pos = (Pos)obj;
        if(pos.getX() == x && pos.getY() == y) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(x,y);
    }

    public String toString() {
        StringBuffer bf = new StringBuffer();
        bf.append("x: "+x+",");
        bf.append("y: "+y);
        return bf.toString();
    }
}

