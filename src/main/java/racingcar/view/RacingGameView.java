package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.Constant.MOVE_FORWARD;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import racingcar.Constant;
import racingcar.controller.ExceptionController;

public class RacingGameView {

    public static void gameResultMessage() {
        System.out.println(Constant.GAME_RESULT);
    }

    public static void inputCarNameMessage() {
        System.out.println(Constant.INPUT_CAR_NAME);
    }

    public static List<String> inputCarName() {
        inputCarNameMessage();
        String inputCarName = readLine();
        List<String> cars = commaBasedSplitCarName(inputCarName);
        ExceptionController.checkIsNotDuplicated(cars);
        return cars;
    }

    public static List<String> commaBasedSplitCarName(final String inputNames) {
        List<String> names = Arrays.asList(inputNames.split(Constant.COMMA));
        ExceptionController.multiCommaException(names);
        ExceptionController.carNameMaxLengthException(names);
        return names;
    }

    public static String inputTryCount() {
        System.out.println(Constant.INPUT_TRY_COUNT);
        return readLine();
    }

    public static int stringTryCountToInteger(String tryCount) {
        try {
            return Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 외에 다른 문자는 사용할 수 없습니다.");
        }
    }

    public static void forwardResult(Map<String, Integer> forwardStatus) {
        for (String carName : forwardStatus.keySet()) {
            int result = forwardStatus.get(carName);
            System.out.println(carName + " : " + MOVE_FORWARD.repeat(result));
        }
        System.out.println();
    }

    private static void winnerMessage(String winner) {
        System.out.println(Constant.WINNER_LIST + winner);
    }

    public static void winner(List<String> carMoveStatus) {
        String winner = String.join(Constant.COMMA_SPACE, carMoveStatus);
        winnerMessage(winner);
    }

    public static int tryCount() {
        String tryCount = inputTryCount();
        if (tryCount.length() > Constant.MAX_CAR_NAME_SIZE) {
            throw new IllegalArgumentException("자동차의 이름은 5글자를 초과할 수 없습니다.");
        }
        return RacingGameView.stringTryCountToInteger(tryCount);
    }
}
