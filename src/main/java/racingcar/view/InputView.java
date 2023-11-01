package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.NameValidator;
import racingcar.validator.TryCountValidator;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String DELIMITER = ",";

    public static List<String> inputCarNames() {
        OutputView.printInputNameMessage();
        return NameValidator.validateName(splitWords(Console.readLine(), DELIMITER));
    }

    public static int inputTryCount() {
        OutputView.printInputTryCountMessage();
        return Integer.parseInt(TryCountValidator.validateTryCount(Console.readLine()));
    }

    private static List<String> splitWords(String string, String delimiter) {
        return Arrays.stream(string.split(delimiter)).toList();
    }
}
