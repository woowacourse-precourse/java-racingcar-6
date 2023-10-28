package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.util.Validator;

public class CarGameService {

    Validator validator = new Validator();

    public void initCarInfo(List<String> carNames, List<Car> cars) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public List<String> extractSeperator(String carInput) {
        List<String> splitedName= List.of(carInput.split(","));
        validator.isRightCarNameInput(splitedName);
        return splitedName;
    }

    public Integer convertGameCountToNumber(String carGameCount) {
        validator.isRightInputGameCount(carGameCount);
        return Integer.parseInt(carGameCount);
    }

}
