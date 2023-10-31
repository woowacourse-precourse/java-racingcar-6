package racingcar.domain;

import java.util.List;

public class InvalidValue {
    public boolean isExceedFiveLetters(List<String> carName) {
        for(String car : carName){
            if (car.length() > 5) {
                return true;
            }
        }
        return false;
    }
}
