package racingcar;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try{
            inputCarName();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void inputCarName() {
        String tm = Console.readLine();
        String[] carNames = parseCarName(tm);
        
    }

    public static String[] parseCarName(String input) {

        String[] names = input.split(",");

        for (String name : names) {
            validateCarName(name);
        }
        return names;
    }

    public static void validateCarName(String name) {
        isBelowFiveWord(name);
    }

    static void isBelowFiveWord(String name) {
        if (5 < name.length()){
            throw new IllegalArgumentException("자동차의 이름이 5글자 이상입니다.");
        }
    }
}
