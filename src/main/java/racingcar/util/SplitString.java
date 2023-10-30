package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class SplitString {

    public static List<String> splitString(String cars) throws IllegalArgumentException {
        String[] carNames = cars.split(",");

        List<String> carsList = Arrays.asList(carNames);
        for (String car : carsList){
            Validation.maxLength(car);
        }
        return carsList;
    }
}
