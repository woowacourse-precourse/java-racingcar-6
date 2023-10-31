package racingcar.service;

import racingcar.model.Cars;
import racingcar.utils.CarNameValidator;
import racingcar.utils.TrialNumberValidator;

public class Service {

    public static Cars setCars(String cars) {
        CarNameValidator validation = new CarNameValidator(cars);
        return new Cars(validation.NAMES);
    }

    public static int setTrialNumber(String num) {
        TrialNumberValidator validation = new TrialNumberValidator(num);
        return Integer.parseInt(validation.ROUND_NUM_STRING);
    }
}
