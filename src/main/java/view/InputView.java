package view;

import camp.nextstep.edu.missionutils.Console;
import validator.NameValidator;
import validator.TryCountValidator;

import java.util.Arrays;
import java.util.List;

public class InputView {
    public static final String DELIMITER = ",";

    public static List<String> inputCarNames() {
        OutputView.printInputCarName();
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
