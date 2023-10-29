package racingcar.validator;

import java.util.List;

public class CarNameValidator {

    public static void checkLength(List<String> carNameList){
        for (String name : carNameList){
            if (name.length() >= 6){
                throw new IllegalArgumentException();
            }
        }
    }
}
