package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class Validator {
    private static boolean isCarNameOverFiveCharacters(){
        List<String> carNameList = Car.getCarName();
        boolean fiveCharacters = true;
        for (String carName : carNameList) {
            if (carName.length() > 5) {
                fiveCharacters = false;
            }
        }
        return fiveCharacters;
    }
}
