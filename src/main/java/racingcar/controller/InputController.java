package racingcar.controller;

import racingcar.Util;
import racingcar.car.CarNameValidator;
import racingcar.car.RacingCar;
import racingcar.car.TryCntValidator;

public class InputController {
    public static RacingCar setRacingCars(){
        CarNameValidator validator = new CarNameValidator(Util.carNamesInput());
        return new RacingCar(validator.NAMELIST);
    }

    public static int setTryCnt(){
        TryCntValidator validator = new TryCntValidator(Util.tryCntInput());
        return Integer.parseInt(validator.TRY_COUNT);
    }
}
