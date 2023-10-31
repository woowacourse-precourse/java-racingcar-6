package racingcar.view;

import static racingcar.constant.MessageConstants.INPUT_CAR_NAME;
import static racingcar.constant.MessageConstants.INPUT_TRY_COUNT;
import static racingcar.constant.MessageConstants.NONE_INSTANTIABLE_CLASS;
import static racingcar.constant.MessageConstants.RESULT;
import static racingcar.constant.MessageConstants.WINNER_DELIMITER;
import static racingcar.constant.MessageConstants.WINNER_PREFIX;
import static racingcar.constant.MessageConstants.WINNER_SUFFIX;

import java.util.List;

public class RacingOutputView {

    private RacingOutputView() {
        throw new AssertionError(NONE_INSTANTIABLE_CLASS);
    }

    public static void outputCarName() {
        System.out.println(INPUT_CAR_NAME);
    }

    public static void outputTryCount() {
        System.out.println(INPUT_TRY_COUNT);
    }

    public static void outputResultMessage() {
        outputNextLine();
        System.out.println(RESULT);
    }

    public static void outputRoundResults(List<String> roundResults) {
        roundResults.forEach(System.out::println);
        outputNextLine();
    }

    public static void outputNextLine() {
        System.out.println();
    }

    public static void outputWinners(List<String> winners) {
        System.out.print(WINNER_PREFIX + WINNER_SUFFIX);
        System.out.print(String.join(WINNER_DELIMITER, winners));
    }

}
