package racingcar.model;

import static racingcar.validator.InputValidator.validateLenOfCar;
import static racingcar.validator.InputValidator.validateName;
import static racingcar.validator.InputValidator.validateNumOfMatches;
import static racingcar.validator.InputValidator.validateStringToInteger;

import java.util.ArrayList;
import java.util.List;

public class Match {
    private List<Car> carList;
    private int numOfMatches;

    public Match(String carListString, String numOfMatchesString) {
        validateName(carListString);
        validateLenOfCar(carListString);
        validateStringToInteger(numOfMatchesString);
        validateNumOfMatches(numOfMatchesString);

        this.carList = new ArrayList<>();
        for (String carString : carListString.split(",")) {
            this.carList.add(new Car(carString));
        }

        this.numOfMatches = Integer.parseInt(numOfMatchesString);
    }

}
