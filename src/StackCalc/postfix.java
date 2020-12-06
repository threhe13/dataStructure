package StackCalc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class postfix{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        str = Convert(str);
        System.out.println(str);
    }
    //후위표기법으로 변환
    public static String Convert(String str){
        Stack<Character> stack = new Stack<Character>();
        int length = str.length();
        String result = "";

        for(int i = 0; i < length; i++){
            char input = str.charAt(i);
            int prior = prior(input);

            switch (input){
                //연산자인 경우
                case'+' :
                case'-' :
                case'*' :
                case'/' :
                    //스택에 값이 있고, 스택에 최후의 값이 입력된 우선순위보다 높거나 같은 경우
                    while(!stack.isEmpty() && prior(stack.peek()) >= prior){
                        //스택에서 모두 배출
                       result += stack.pop();
                    }
                    //우선순위가 낮은 경우에는 그냥 스택에 저장
                    stack.push(input);
                    break;
                case'(' :
                    //여는 괄호일 경우 스택에 바로 저장
                    stack.push(input);
                    break;
                case')' :
                    //닫는 괄호일 경우 스택에 여는 괄호가 나올 때까지 스택에서 배출
                    while(!stack.isEmpty() && stack.peek() != '('){
                        result += stack.pop();
                    }
                    //바로 여는 괄호가 나오는 경우 결과값에 들어가지 않게 삭제
                    stack.pop();
                    break;
                default:
                    //기본 문자열이나 숫자(우선순위 -1)는 바로 결과값에 출력
                    result += input;
            }
        }
        while(!stack.isEmpty()){
            result += stack.pop();
        }
        return result;
    }
    //우선순위 비교
    public static boolean isPrior(char inStack, char readInput){
        int option1 = prior(inStack);
        int option2 = prior(readInput);
        //입력값 비교를 통해 참, 거짓 구분
        if(option1 >= option2){
            return true;
        } else return false;
    }
    //연산자 우선순위 설정
    public static int prior(char a){
        if(a == '*' || a == '/'){
            return 3; //곱하기, 나누기 가장 큰 우선순위
        }
        else if(a == '+' || a == '-'){
            return 2; //더하기, 빼기는 곱하기, 나누기 보다 하위 우선순위
        }
        else if(a == '('){
            return 1; //구별을 위한 순위배정
        }
        return -1; //연산에 필요한 피연산자의 경우 우선순위 -1 -> 바로 문자열에 입력
    }
}