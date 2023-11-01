package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.util.ExceptionMessage;

public class InputView {

    private static final String CAR_NAME_SEPARATOR = ",";

    public static List<String> inputCarNames() {
        OutputView.printInputCarNames();
        List<String> carNames = splitCarName(Console.readLine());
        return trimCarName(carNames);
    }

    public static int inputTryCount() {
        OutputView.printInputGameTryCounts();
        return convertTryCount(Console.readLine());
    }

    private static List<String> splitCarName(String carNamesInput) {
        return List.of(carNamesInput.split(CAR_NAME_SEPARATOR));
    }

    private static List<String> trimCarName(List<String> carNames) {
        return carNames.stream()
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private static int convertTryCount(String tryCountInput) {
        try {
            return Integer.parseInt(tryCountInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.GAME_TRY_COUNTS_FORMAT);
        }
    }
}
