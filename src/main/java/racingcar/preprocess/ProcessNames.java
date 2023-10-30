package racingcar.preprocess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProcessNames {
    public List<String> processNames(String inputCarName) {
        String removeSpaces = removeSpaces(inputCarName);
        return splitCarNames(removeSpaces);
    }

    private String removeSpaces(String carName) {
        return carName.replaceAll(" ", "");
    }

    private List<String> splitCarNames(String carName) {
        return new ArrayList<>(Arrays.asList(carName.split(",")));
    }
}
