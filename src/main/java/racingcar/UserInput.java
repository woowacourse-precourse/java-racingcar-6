package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class UserInput {
    public static final String INPUT_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";

    public static List<String> inputNames() {
        System.out.println(INPUT_NAME_MESSAGE);
        String input = Console.readLine();
        Validator.blankCheck(input);
        List<String> names = List.of(input.split(","));
        Validator.nameDuplicatenCheck(names);

        return List.of(input.split(","));
    }

    public static int inputNumberOfGames() {
        System.out.println(INPUT_NUMBER_MESSAGE);
        String input = Console.readLine();

        Validator.blankCheck(input);
        Validator.countZeroCheck(input);
        Validator.countNumericCheck(input);

        return Integer.parseInt(input);
    }
}
