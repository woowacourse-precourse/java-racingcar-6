package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.validator.InputValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    private final InputValidator inputValidator;

    public Utils() {
        inputValidator = new InputValidator();
    }

    public List<String> convertStringToList(String names) {
        inputValidator.validateCarName(names);
        return Arrays.stream(names.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public int convertStringToNumber(String tryNumber) {
        inputValidator.validateTryNumber(tryNumber);
        return Integer.parseInt(tryNumber);
    }

    public static String formatListToString(List<String> winners) {
        return String.join(", ", winners);
    }

    public static int makeRandomNumber() {
        return Randoms.pickNumberInRange(0,9);
    }
}
