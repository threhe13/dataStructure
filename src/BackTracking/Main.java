package BackTracking;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

public class Main {
    static Stack<XY> stack = new Stack<XY>();
    static Map<XY, Boolean> isVisitHistory = new HashMap<XY, Boolean>();

    public static void main(String[] args){

        XY xy = new XY(0, 0);
        stack.push(xy);

        while(mazeArray[xy.getX()][xy.getY()] != 2){
            System.out.println(xy);
            isVisitHistory.put(xy, true);

            XY movableXY = xyMove(xy);
            if(movableXY != null){
                stack.push(movableXY);
            }
            else{
                movableXY = stack.pop();
            }
            xy = movableXY;
        }

    }

    //이동할 수 있는 위치반환, 이동할 수 없다면 null 반환!
    static XY xyMove(XY xy){
        int x = xy.getX();
        int y = xy.getY();

        for(int i = 0; i < rotateArray.length; i++){
            int[] direction = rotateArray[i];
            int moveX = x + direction[0];
            int moveY = y + direction[1];

            if(moveX >= 0 && moveX <= 3 && moveY >= 0 && moveY <= 3){
                if(mazeArray[moveX][moveY] == 0){
                    continue;
                }

                XY moveXY = new XY(moveX, moveY);

                boolean isVisit = stack.contains(moveXY);
                if(!isVisit){
                    Boolean VisitHistory = isVisitHistory.get(moveXY);
                    if(VisitHistory == null) {
                        return moveXY;
                    }
                }
            }
        }
        return null;
    }

    static int[][] mazeArray = {
            {1, 0, 0, 0}, //0 = 벽 / 1 = 통로 / 2 = 출구
            {1, 1, 1, 0},
            {0, 1, 0, 0},
            {0, 1, 1, 1},
            {0, 2, 0, 0}
    };

    static int[][] rotateArray = {
            {0,1},//우
            {1,0},//하
            {0,-1},//좌
            {-1,0}//상
    };
}

class XY{

    int x;
    int y;

    public XY(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public boolean equals(Object obj){
        //obj가 null값이 아니거나, obj가 XY로 형변환이 가능해야 함
        if(obj == null || !(obj instanceof XY)){
            return false;
        }
        //obj를 XY로 형변환해서 호출
        XY xy = (XY)obj;
        //형변환된 x와 y가 같은 경우에만 true 출력
        if(xy.getX() == x && xy.getY() == y){
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
