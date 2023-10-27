package racingcar.utill;

import static racingcar.utill.Validator.attemptNumberValidation;
import static racingcar.utill.Validator.carNameValidation;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class Converter {

    public static int attemptStringToInt(String stringValue) {
        attemptNumberValidation(stringValue);
        return Integer.parseInt(stringValue);
    }

    public static List<Car> stringToCarList(String carNameString) {
        List<Car> carList = new ArrayList<>();
        String[] split = carNameString.split(",", -1);

        for (String a : split) {
            carNameValidation(a);
            carList.add(new Car(a));
        }

        return carList;
    }
}
