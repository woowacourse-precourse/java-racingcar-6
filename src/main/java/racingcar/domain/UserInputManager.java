package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserInputManager {

    public static int inputNumberOfAttempts() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        input = removeSpace(input);
        InputValidator.isNumeric(input);

        return Integer.parseInt(input);
    }

    public static List<String> inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        return splitInput(removeSpace(input));
    }

    private static List<String> splitInput(String input) {
        return Arrays.stream(input.split(","))
                .filter(name -> InputValidator.checkCarNameLength(name))
                .collect(Collectors.toList());
    }

    private static String removeSpace(String input) {
        return input.replaceAll(" ", "");
    }
}
