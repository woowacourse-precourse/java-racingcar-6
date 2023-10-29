package racingcar.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringToList {
    public List<String> analysisCarNames(String carNameInput) {
        return new ArrayList<>(Arrays.asList(carNameInput.split(",")));
    }

    public int analysisTryCountNumber(String tryCountNumInput) {
        return Integer.parseInt(tryCountNumInput);
    }
}

