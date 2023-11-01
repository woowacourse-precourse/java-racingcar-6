package racingcar.util;

import racingcar.view.ErrorMessage;

import java.util.ArrayList;
import java.util.HashSet;

public class CarNameValidator {

    public static void validInputCarName(ArrayList<String> carNames) {
        validCarNameBlank(carNames);
        validCarNameLength(carNames);
        validCarsDuplicate(carNames);
    }

    private static void validCarNameLength(ArrayList<String> cars) {
        for(String car : cars){
            if(car.length() > 5) throw new IllegalArgumentException(ErrorMessage.REQUIRE_LENGTH_UNDER_FIVE.message());
        }
    }

    private static void validCarNameBlank(ArrayList<String> cars) {
        for(String car : cars){
            if (car.contains(" ")) throw new IllegalArgumentException(ErrorMessage.REQUIRE_NOT_BLANK.message());
        }
    }

    private static void validCarsDuplicate(ArrayList<String> cars){
        HashSet<String> set = new HashSet<>(cars);
        if(set.size() != cars.size()) throw new IllegalArgumentException(ErrorMessage.REQUIRE_NOT_DUPLICATE.message());
    }
}
