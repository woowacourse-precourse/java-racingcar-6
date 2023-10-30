package racingcar;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        inputCarName();
    }

    public static void inputCarName(){
        String tm = Console.readLine();

        System.out.println(Arrays.toString(parseCarName(tm)));
    }

    public static String[] parseCarName(String input){

        String[] names = input.split(",");

        return names;
    }
}
