package racingcar;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
    
    public static List<String> askCarName() {
        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
        String input = readLine();
        checkCarNameAsCommas(input);

        List<String> names = new ArrayList<>();
        for (String name : input.split(",")) {
            checkCarNameAsLength(name);
            names.add(String.valueOf(name));
        }
        return names;
    }

    public static int askRound() {
        System.out.print("시도할 회수는 몇회인가요?\n");
        String input = readLine();
        checkRound(input);

        int round = Integer.parseInt(input);
        return round;
    }

    public static void checkCarNameAsCommas(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException("자동차 이름은 2개 이상, 쉼표로 구분되어야 합니다.");
        }
    }

    public static void checkCarNameAsLength(String input) {
        if (input.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public static void checkRound(String input) {
        if (input.isEmpty() || !input.matches("\\d+") || Integer.parseInt(input) < 1) {
            throw new IllegalArgumentException("자연수를 입력하십시오.");
        }
    }
}


