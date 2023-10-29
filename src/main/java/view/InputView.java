package view;

import camp.nextstep.edu.missionutils.Console;
import validator.NameValidator;

import java.util.Arrays;
import java.util.List;

public class InputView {
    public static final String DELIMITER = ",";

    public static List<String> inputCarNames() {
        OutputView.printInputCarName();
        return NameValidator.nameValidator(splitWords(Console.readLine(), DELIMITER));
    }

    private static List<String> splitWords(String string, String delimiter) {
        return Arrays.stream(string.split(delimiter)).toList();
    }
}
