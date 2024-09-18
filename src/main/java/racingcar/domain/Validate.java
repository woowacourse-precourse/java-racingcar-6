package racingcar.domain;

import java.util.List;

public class Validate {

    public static List<String> validator(List<String> carNames) {
        for(String carName : carNames) {
            if(carName.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
        return carNames;
    }
}
