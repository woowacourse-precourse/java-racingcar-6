package racingcar.service;

import java.util.HashMap;
import java.util.regex.Pattern;
import racingcar.exception.Exception;

public class RacingService {

    private static final String STRING_REGEX = "^([A-Za-z]+(,[A-Za-z]+)+)$";
    private static final String INTEGER_REGEX = "^[0-9]+$";

    public static HashMap<String, String> enterCarName(String args) {
        String car = stringValidation(args);
        HashMap<String, String> cars = new HashMap<>();
        String[] arr = car.split(",");
        for (String carName : arr) {
            cars.put(carName, "");
        }
        return cars;
    }

    public static Integer enterRoundNumber(String args) {
        return integerValidation(args);
    }

    private static String stringValidation(String args) {
        if (!Pattern.matches(STRING_REGEX, args)) {
            Exception.invalidValueEntered("잘못된 레이싱카 이름을 입력했습니다, 또는 기준을 잘못 입력했을 수 있습니다!");
        }
        return args;
    }

    private static Integer integerValidation(String args) {
        if (!Pattern.matches(INTEGER_REGEX, args)) {
            Exception.invalidValueEntered("잘못된 라운드 수를 입력했습니다, 숫자만 입력할 수 있습니다.");
        }
        return Integer.parseInt(args);
    }
}
