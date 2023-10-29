package racingcar.utill;

import static racingcar.utill.Validator.attemptNumberValidation;
import static racingcar.utill.Validator.carNameValidation;
import static racingcar.utill.Validator.duplicateCarNameValidation;
import static racingcar.utill.Validator.nullInputValidation;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class Converter {

    public static int attemptStringToIntCovert(String stringValue) {
        nullInputValidation(stringValue);
        attemptNumberValidation(stringValue);
        return Integer.parseInt(stringValue);
    }

    public static List<Car> stringToCarListConvert(String carsNameString) {
        nullInputValidation(carsNameString);
        List<Car> carList = new ArrayList<>();
        String[] splitName = carsNameString.split(",", -1);

        for (String name : splitName) {
            carNameValidation(name);
            carList.add(new Car(name));
        }

        duplicateCarNameValidation(carList);

        return carList;
    }

    public static String stringListToStringConvert(List<String> stringList) {
        return String.join(", ", stringList);
    }
}
