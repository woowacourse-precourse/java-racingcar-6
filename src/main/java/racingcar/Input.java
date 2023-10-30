package racingcar;
import camp.nextstep.edu.missionutils.Console;
import java.lang.IllegalArgumentException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Input {
    public static ArrayList<String> nameInput() throws IllegalArgumentException{
        String answer;
        String[] answerArray;
        ArrayList<String> result = new ArrayList<>();
        Set<String> nameIdentify = new HashSet<String>();
        Output.NameText();
        answer = ReadLineError();
        EmptyError(answer);
        EndNotCharError(answer);
        answerArray = answer.split(",");
        for(String str : answerArray) {
            SizeError(str,result,nameIdentify);
        }
        for(String str : answerArray){
            NotCharError(str);
        }
        DuplicationError(result,nameIdentify);
        return result;
    }
    public static int CountInput() throws IllegalArgumentException{
        String answer;
        int result;
        Output.CountText();
        answer = ReadLineError();
        EmptyError(answer);
        NotNumberError(answer);
        result = Integer.parseInt(answer);
        return result;
    }
    static void NotNumberError(String answer) throws IllegalArgumentException{
        int test;
        for(int i = 0 ; i<answer.length();i++){
            test = answer.charAt(i) - '0';
            if (test < 1 || test > 9) {
                throw new IllegalArgumentException("input type error");
            }
        }
    }

    static void NotCharError(String str) throws IllegalArgumentException{
        for (int i = 0; i < str.length(); i++) {
            char test = str.charAt(i);
            if (!Character.isLetter(test)) {
                throw new IllegalArgumentException("not char error");
            }
        }
    }
    public static void DuplicationError(ArrayList<String> result,Set<String> nameIdentify) throws IllegalArgumentException{
        if(nameIdentify.size() != result.size()){
            throw new IllegalArgumentException("duplication error");
        }
    }
    public static String ReadLineError() throws IllegalArgumentException{
        String answer;
        try {
            answer = Console.readLine();
        } catch (Exception e) {
            throw new IllegalArgumentException("readLine error");
        }
        return answer;
    }

    public static void EmptyError(String answer) throws IllegalArgumentException{
        if(answer.isEmpty()){
            throw new IllegalArgumentException("empty error");
        }
    }

    public static void EndNotCharError(String answer) throws IllegalArgumentException{
        if(answer.charAt(answer.length() - 1) == ','){
            throw new IllegalArgumentException("not char error");
        }
    }

    public static void SizeError(String answer,ArrayList<String> result,Set<String> nameIdentify) throws IllegalArgumentException{
        if(answer.isEmpty()){
            throw new IllegalArgumentException("empty error");
        } else if(answer.length() > 5){
            throw new IllegalArgumentException("size error");
        } else{
            result.add(answer);
            nameIdentify.add(answer);
        }
    }
}
