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

    public boolean isNaturalNumber(String input) {
        try {
            int number = Integer.parseInt(input);
            if(number > 0){
                return true;
            }
            return false;
        }catch (Exception e){
            return false;
        }
    }
}
