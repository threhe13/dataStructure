package CallStack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

interface Stack<T>{
    public void push(T obj);
    public T pop();
}

class MyStack<T> implements Stack<T>{
    ArrayList<T> list = new ArrayList<T>();
    int top = -1;

    @Override
    public void push(T obj) {
        list.add(obj);
        top++;
    }

    @Override
    public T pop() {
        String str = list.remove(top).toString();
        top--;
        return (T) str;
    }
}

class Status{

    int Current;
    int Min;
    int Max;

    public Status(int value){
        this.Min = value;
        this.Max = value;
        this.Current = value;
    }

    public String toString(){
        return Current+" "+Min+" "+Max;
    }


    public static Status sCompare(Status s1, Status st){

    if(s1.Min < st.Min){
        st.Min = s1.Min;
    }

    if(s1.Max > st.Max){
        st.Max = s1.Max;
    }

    return st;
    }
}


public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int repeat = Integer.parseInt(br.readLine());

        MyStack<Status> stack = new MyStack<Status>();

        for(int i = 0; i < repeat; i++){
            String[] str = br.readLine().split(" ");
            if(str[0].equals("push")){
                int input = Integer.parseInt(str[1]);

                if(stack.top == -1){
                    stack.push(new Status(input));
                }
                else{
                    Status st = Status.sCompare(stack.list.get(stack.top), new Status(input));
                    stack.push(st);
                }

            }
            else if(str[0].equals("pop")){

                System.out.println(stack.pop());

            }
        }
    }
}
