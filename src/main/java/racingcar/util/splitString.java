package racingcar.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class splitString {

    public static List<String> splitString(String cars) throws IllegalArgumentException {
        String[] carNames = cars.split(",");

        List<String> carsList = Arrays.asList(carNames);
        for (String car : carsList){
            validation.maxLength(car);
        }
        return carsList;
    }
}
