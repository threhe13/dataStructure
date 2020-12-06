import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class TestCase1{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<Character>();

        String str;
        String result = "No Error";

        while((str = br.readLine()) != null){

            for(int i = 0; i < str.length(); i++){

                char input = str.charAt(i);

                if(input == '(' || input == '[' || input == '{'){
                    if(stack.isEmpty()) {
                        stack.push(input);
                    }
                    else if(stack.peek() != '\'' || stack.peek() != '\"'){
                        stack.push(input);
                    }
                }

                else if(input == ')' || input == ']' || input == '}'){
                    if(!stack.isEmpty() && stack.peek() != '\'' && stack.peek() != '\"'){
                        if(input == ')' && stack.peek() == '('){
                            stack.pop();
                        }
                        else if(input == ']' && stack.peek() == '['){
                            stack.pop();
                        }
                        else if(input == '}' && stack.peek() == '{'){
                            stack.pop();
                        }
                        else{
                            result = "Compile Error";
                            break;
                        }
                    }
                    else if(stack.isEmpty()){
                        result = "Compile Error";
                        break;
                    }
                }

                else if(input == '\'' || input == '\"'){
                    if(input == '\'' && stack.peek() != '\''){
                        stack.push(input);
                    }
                    else if(input == '\"' && stack.peek() != '\"'){
                        stack.push(input);
                    }
                    else if(input == '\'' && stack.peek() == '\''){
                        stack.pop();
                    }
                    else if(input == '\"' && stack.peek() == '\"'){
                        stack.pop();
                    }

                }
            }

            if(!stack.isEmpty()){
                result = "Compile Error";
            }

            System.out.println(result);
        }

        System.out.println(result);
    }
}