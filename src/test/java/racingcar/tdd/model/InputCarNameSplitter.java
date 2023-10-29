package racingcar.tdd.model;

import static racingcar.tdd.config.RacingConfig.CAR_NAME_SPLIT_DELIM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputCarNameSplitter {
    public static List<String> splitInput(String carNames) {
        String delim = CAR_NAME_SPLIT_DELIM.getContent();
        String[] splitArr = carNames.split(delim);

        return new ArrayList<>(Arrays.asList(splitArr));
    }
}
