package racingcar;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static List<String> askCarName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
        String input = readLine();

        List<String> names = new ArrayList<>();
        for (String name : input.split(",")) {
            names.add(String.valueOf(name));
        }
        return names;
    }

    public static int askRound(){
        String input = readLine();
        int round = Integer.parseInt(input);
        return round;
    }
}
