package racingcar;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = readLine();
        ArrayList<String> car = new ArrayList<String>(List.of(input.split(",")));
        System.out.println(car);
    }
}
