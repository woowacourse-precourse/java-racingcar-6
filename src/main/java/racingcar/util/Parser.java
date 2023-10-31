package racingcar.util;

import java.util.List;
import java.util.Arrays;

public class Parser {
    public List<String> getSplitString(String str) {
        String[] splitStrings = str.split(",");
        return checkNamingCondition(Arrays.asList(splitStrings));
    }

    private List<String> checkNamingCondition(List<String> carNames) {
        for (String carName : carNames) {
            checkNamingException(carName);
        }
        return carNames;
    }

    private void checkNamingException(String str) throws IllegalArgumentException{
        if (str.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
}
