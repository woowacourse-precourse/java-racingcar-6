package racingcar;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.lang.IllegalArgumentException;

import camp.nextstep.edu.missionutils.Console;



public class Input {
    static final int MAX_CAR_NAME = 5;
    static final int INPUT_MIN_DISGIT = 0;
    static final int INPUT_MAX_DISGIT = 9;

    public static ArrayList<String> nameInput() throws IllegalArgumentException{
        String answer;
        String[] answerArray;
        ArrayList<String> result = new ArrayList<>();
        Set<String> nameIdentify = new HashSet<String>();
        Output.nameText();
        answer = readLineError();
        emptyError(answer);
        endNotCharError(answer);
        answerArray = answer.split(",");
        for (String str : answerArray) {
            SizeError(str,result,nameIdentify);
        }
        for (String str : answerArray) {
            notCharError(str);
        }
        duplicationError(result,nameIdentify);
        return result;
    }

    public static int moveCountInput() throws IllegalArgumentException{
        String answer;
        int result;
        Output.moveCountText();
        answer = readLineError();
        emptyError(answer);
        notNumberError(answer);
        result = Integer.parseInt(answer);
        return result;
    }

    static void notNumberError(String answer) throws IllegalArgumentException{
        int test;
        for (int i = 0 ; i<answer.length();i++) {
            test = answer.charAt(i) - '0';
            if (test <= INPUT_MIN_DISGIT || test >= INPUT_MAX_DISGIT) {
                throw new IllegalArgumentException("input type error");
            }
        }
    }

    static void notCharError(String str) throws IllegalArgumentException{
        for (int i = 0; i < str.length(); i++) {
            char test = str.charAt(i);
            if (!Character.isLetter(test)) {
                throw new IllegalArgumentException("not char error");
            }
        }
    }

    public static void duplicationError(ArrayList<String> result,Set<String> nameIdentify) throws IllegalArgumentException{
        if (nameIdentify.size() != result.size()) {
            throw new IllegalArgumentException("duplication error");
        }
    }

    public static String readLineError() throws IllegalArgumentException{
        String answer;
        try {
            answer = Console.readLine();
        } catch (Exception e) {
            throw new IllegalArgumentException("readLine error");
        }
        return answer;
    }

    public static void emptyError(String answer) throws IllegalArgumentException{
        if (answer.isEmpty()){
            throw new IllegalArgumentException("empty error");
        }
    }

    public static void endNotCharError(String answer) throws IllegalArgumentException{
        int lastIndex = answer.length() - 1;
        if (answer.charAt(lastIndex) == ',') {
            throw new IllegalArgumentException("not char error");
        }
    }

    public static void SizeError(String answer,ArrayList<String> result,Set<String> nameIdentify) throws IllegalArgumentException{
        if (answer.isEmpty()) {
            throw new IllegalArgumentException("empty error");
        } else if (answer.length() > MAX_CAR_NAME) {
            throw new IllegalArgumentException("size error");
        } else {
            result.add(answer);
            nameIdentify.add(answer);
        }
    }
}
