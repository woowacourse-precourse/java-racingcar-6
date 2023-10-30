package racingcar.view;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.GameController;
import racingcar.validation.InputValidation;

public class InputView {

    private static final String GAME_START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String GAME_NUMBER_OF_ATTEMPTS = "시도할 회수는 몇회인가요?";
    private static final String EXECUTION_RESULT = "\n실행 결과";



    public static void startGame() {
        System.out.println(GAME_START_MESSAGE);
        List<String> carNames = inputCarName();
        int numberOfAttempts = inputTryCount();
        GameController gameController = new GameController();
        gameController.playGame(String.join(",", carNames), numberOfAttempts);
    }

    public static List<String> inputCarName() {
        String input = Console.readLine();
        List<String> carNames = InputValidation.validateNameAndSplit(input);
        InputValidation.validateNameList(carNames);
        return carNames;
    }

    public static int inputTryCount() {
        System.out.println(GAME_NUMBER_OF_ATTEMPTS);
        String input = Console.readLine();
        System.out.println(EXECUTION_RESULT);
        return InputValidation.validateIsNumber(input);
    }
}
