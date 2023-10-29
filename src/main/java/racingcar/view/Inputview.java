package racingcar.view;

import java.util.Arrays;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import racingcar.validation.InputValidation;

public class Inputview {

    private static final String GAME_START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String GAME_NUMBER_OF_ATTEMPTS = "시도할 회수는 몇회인가요?";

    public static void startGame() {
        System.out.println(GAME_START_MESSAGE);
        inputCarName();
    }

    public static List<String> inputCarName() {
        String input = Console.readLine();
        return InputValidation.validationNameSeparate(InputValidation.validateAndSplit(input));
    }

    public static int tryGameNumber() {
        System.out.println(GAME_NUMBER_OF_ATTEMPTS);
        String input = String.valueOf(Console.readLine());
        return InputValidation.carNumericValidation(input);
    }

    public int carNumericValue() {
        return 0;
    }
}
