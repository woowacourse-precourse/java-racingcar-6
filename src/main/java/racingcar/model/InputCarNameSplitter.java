package racingcar.model;

import static racingcar.config.RacingConfig.CAR_NAME_SPLIT_DELIM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputCarNameSplitter {
    public List<String> splitInputCarNames(String carNames) {
        String[] carNamesSplit = carNames.split(CAR_NAME_SPLIT_DELIM.getContent());

        return new ArrayList<>(Arrays.asList(carNamesSplit));
    }
}
