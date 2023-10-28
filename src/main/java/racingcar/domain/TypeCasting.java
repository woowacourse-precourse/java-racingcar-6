package racingcar.domain;

import racingcar.view.validator.InputValidator;

public class TypeCasting {
    public static RacingCars stringToRacingCars(String stringCars) {
        InputValidator.validateCarName(stringCars);
        RacingCars racingcars = new RacingCars();
        String[] stringArrayCars = stringCars.split(",");
        for (String car : stringArrayCars) {
            racingcars.add(new RacingCar(car));
        }
        return racingcars;
    }

    public static int stringToInteger(String number) {
        // validate(number);
        return Integer.parseInt(number);
    }
}
