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

    public static int makeRandomNumber() {
        return Randoms.pickNumberInRange(0,9);
    }
}
