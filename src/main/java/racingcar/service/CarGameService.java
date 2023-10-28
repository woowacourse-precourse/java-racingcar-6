package racingcar.service;

import java.util.List;
import racingcar.util.Validator;

public class CarGameService {

    Validator validator = new Validator();


    public List<String> extractSeperator(String carInput) {
        List<String> splitedName= List.of(carInput.split(","));
        validator.isRightCarNameInput(splitedName);
        return splitedName;
    }

    public Long convertGameCountToNumber(String carGameCount) {
        validator.isRightInputGameCount(carGameCount);
        return Long.parseLong(carGameCount);
    }
}
