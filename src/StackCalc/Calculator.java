package StackCalc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Calculator {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Double> stack = new Stack<Double>();
        String str = br.readLine();

        //후위표기식 출력
        postfix p = new postfix();
        String postfix = p.Convert(str);
        System.out.println(postfix);

        //후위표기식 계산
        int length = postfix.length();
        String[] input = postfix.split("");

        for(int i = 0; i < length; i++){

            if(input[i].equals("+") || input[i].equals("-") || input[i].equals("*") || input[i].equals("/")){
                CalcPostfix(stack, stack.pop(), stack.pop(), input[i]);
            }
            else{
                double convert = Double.parseDouble(input[i]);
                stack.push(convert);
            }
        }
        System.out.printf("%.2f", stack.peek());
    }

    public static void CalcPostfix(Stack<Double> stack, double a, double b, String input){
        switch (input){
            case "*" :
                stack.push(b * a);
                break;
            case "/" :
                stack.push(b / a);
                break;
            case "+" :
                stack.push(b + a);
                break;
            case "-" :
                stack.push(b - a);
                break;
        }
    }
}
