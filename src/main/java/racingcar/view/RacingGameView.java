package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;
import java.util.List;
import racingcar.Constant;
import racingcar.controller.ExceptionController;

public class RacingGameView {

    public static void gameResultMessage() {
        System.out.println(Constant.GAME_RESULT);
    }

    public static void inputCarNameMessage() {
        System.out.println(Constant.INPUT_CAR_NAME);
    }

    public static String inputCarName() {
        inputCarNameMessage();
        String inputCarName = readLine();

        ExceptionController.stringBlankException(inputCarName);

        return inputCarName;
    }

    public static void inputTryCountMessage() {
        System.out.println(Constant.INPUT_TRY_COUNT);
    }

    public static int inputTryCount() {
        inputTryCountMessage();
        return ExceptionController.tryCountNotIntException(readLine());
    }

    public static void forwardResultMessage(String carName, String result) {
        System.out.println(carName + " : " + result);
    }

    public static void blankLine() {
        System.out.println();
    }

    public static void forwardResult(HashMap<String, String> forwardStatus) {
        for (String carName : forwardStatus.keySet()) {
            String result = forwardStatus.get(carName);
            forwardResultMessage(carName, result);
        }
        blankLine();
    }

    public static void winner(List<String> carMoveStatus) {
        String winner = String.join(", ", carMoveStatus);
        System.out.println("최종 우승자 : " + winner);
    }
}
