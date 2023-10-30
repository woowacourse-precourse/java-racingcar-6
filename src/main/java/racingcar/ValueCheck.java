package racingcar;

import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.parseInt;

public class ValueCheck {
    void sizeUnderFive(List<String> carList){
        for (String carName:carList) {
            List<String> carNameSplitArray = Arrays.asList(carName.split(""));
            if (carNameSplitArray.size() >= 5) {
                throw new IllegalArgumentException();
            }
        }
    }
    void inputContainsComma(String input){
        if (!input.contains(",")) {
            throw new IllegalArgumentException();
        }
    }

    void isInt(String input) {
        try {
            parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
