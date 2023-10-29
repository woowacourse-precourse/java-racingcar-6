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
        try {
            answer = Console.readLine();
        } catch (Exception e) {
            throw new IllegalArgumentException("readLine error");
        }
        answerArray = answer.split(",");

        // 공백 확인 및 5 글자 이상 예외처리
        for(String str : answerArray) {
            if(str.isEmpty()){
                throw new IllegalArgumentException("empty error");
            } else if(str.length() > 5){
                throw new IllegalArgumentException("size error");
            } else{
                result.add(str);
                nameIdentify.add(str);
            }
        }

        // 이름 중복확인
        if(nameIdentify.size() != result.size()){
            throw new IllegalArgumentException("duplication error");
        }
        return result;
    }

    public static int CountInput() throws IllegalArgumentException{
        String answer;
        int test;
        int result;

        // readline 에러 확인하기
        try {
            answer = Console.readLine();
        } catch (Exception e) {
            throw new IllegalArgumentException("readLine error");
        }

        // 공백 확인하기
        if(answer.isEmpty()){
            throw new IllegalArgumentException("empty error");
        }

        // 숫자로 구성되어있는지 확인하기
        for(int i = 0 ; i<answer.length();i++){
            test = answer.charAt(i) - '0';
            if (test < 1 || test > 9) {
                throw new IllegalArgumentException("input type error");
            }
        }
        result = Integer.parseInt(answer);

        return result;
    }
}
