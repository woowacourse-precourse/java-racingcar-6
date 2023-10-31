package racingcar;

import Car.Car;
import java.util.ArrayList;
import java.util.List;

public class Validator {
    public static void validateCarName(String userInput) {
        String[] carNames = userInput.split(",");

        for (String carName : carNames) {
            if (carName.trim().length() > 5) {
                throw new IllegalArgumentException("자동차의 이름은 5자 이하만 가능합니다.");
            }
        }
    }
    public static void validateRepeatCount(String userInputRepeatCount){
        try {
            Integer.parseInt(userInputRepeatCount);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("자동차의 이름은 5자 이하만 가능합니다.");
        }
    }
}



