package service;

import model.validator.CarNameValidator;
import model.RacingCars;
import model.validator.RoundNumValidator;

public class InputService {
    public static RacingCars setRacingCars(String carInput) {
        CarNameValidator validation = new CarNameValidator(carInput);
        return new RacingCars(validation.nameList);
    }

    public static int setRoundNum(String roundInput) {
        RoundNumValidator validation = new RoundNumValidator(roundInput);
        return Integer.parseInt(validation.roundNumString);
    }
}
