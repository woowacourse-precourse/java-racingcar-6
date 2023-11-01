package racingcar.service;

import java.util.HashMap;
import java.util.regex.Pattern;
import racingcar.exception.Exception;

public class RacingService {

    private static final String STRING_REGEX = "^([A-Za-z]+(,[A-Za-z]+)+)$";

    public static HashMap<String, String> enterCarName(String args) {
        String car = stringValidation(args);
        HashMap<String, String> cars = new HashMap<>();
        String[] arr = car.split(",");
        for (String carName : arr) {
            cars.put(carName, "");
        }
        return cars;
    }

    private static String stringValidation(String args) {
        if (!Pattern.matches(STRING_REGEX, args)) {
            Exception.invalidValueEntered();
        }
        return args;
    }
}
