package racingcar.model;

import static racingcar.validator.InputValidator.validateDuplicateName;
import static racingcar.validator.InputValidator.validateLenOfCar;
import static racingcar.validator.InputValidator.validateName;
import static racingcar.validator.InputValidator.validateNumOfMatches;
import static racingcar.validator.InputValidator.validateStringToInteger;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Race {
    private List<Car> carList;
    private int numOfMatches;

    public Race(String carListString, String numOfMatchesString) {
        validateName(carListString);
        validateDuplicateName(carListString);
        validateLenOfCar(carListString);
        validateStringToInteger(numOfMatchesString);
        validateNumOfMatches(numOfMatchesString);

        this.carList = new ArrayList<>();
        for (String carString : carListString.split(",")) {
            this.carList.add(new Car(carString));
        }

        this.numOfMatches = Integer.parseInt(numOfMatchesString);
    }

    public List<Map<String, Integer>> getAllMatchesResult() {
        List<Map<String, Integer>> allMatchesResult = new ArrayList<>();
        for (int i = 0; i < this.numOfMatches; i++) {
            start();
            allMatchesResult.add(getPerMatchResult());
        }
        return allMatchesResult;
    }

    private void start() {
        for (Car car : this.carList) {
            car.move(Randoms.pickNumberInRange(0, 9));
        }
    }

    public Map<String, Integer> getPerMatchResult() {
        Map<String, Integer> perMatchResult = new HashMap<>();
        for (Car car : this.carList) {
            perMatchResult.put(car.getName(), car.getDistance());
        }
        return perMatchResult;
    }
}
