package racingcar.model;

import static racingcar.validator.InputValidator.validateNumOfMatches;
import static racingcar.validator.InputValidator.validateStringToInteger;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Race {
    private final List<Car> carList;
    private final int numOfMatches;

    public Race(String carListString, String numOfMatchesString) {
        validateStringToInteger(numOfMatchesString);
        validateNumOfMatches(numOfMatchesString);

        this.carList = new ArrayList<>();
        for (String carString : carListString.split(",")) {
            this.carList.add(new Car(carString));
        }

        this.numOfMatches = Integer.parseInt(numOfMatchesString);
    }

    public void match() {
        for (Car car : this.carList) {
            car.move(Randoms.pickNumberInRange(0, 9));
        }
    }

    public Map<String, Integer> getPerMatchResult() {
        Map<String, Integer> perMatchResult = new LinkedHashMap<>();
        for (Car car : this.carList) {
            perMatchResult.put(car.getName(), car.getDistance());
        }
        return perMatchResult;
    }

    public List<String> getWinner() {
        int max_distance = checkMaxDistance();
        List<String> winner = new ArrayList<>();
        for (Car car : this.carList) {
            if (car.getDistance() == max_distance) {
                winner.add(car.getName());
            }
        }
        return winner;
    }

    public int checkMaxDistance() {
        int maxDistance = 0;
        for (Car car : this.carList) {
            maxDistance = Math.max(maxDistance, car.getDistance());
        }
        return maxDistance;
    }

    public int getNumOfMatches() {
        return numOfMatches;
    }
}
