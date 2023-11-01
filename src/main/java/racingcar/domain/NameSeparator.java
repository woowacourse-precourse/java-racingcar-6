package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import racingcar.common.Constants;

public class NameSeparator {

    public static List<String> separateNamesByComma(String inputNames) {
        Validator.validateInputNames(inputNames);
        return Arrays.stream(inputNames.split(Constants.COMMA))
                .toList();
    }

}
