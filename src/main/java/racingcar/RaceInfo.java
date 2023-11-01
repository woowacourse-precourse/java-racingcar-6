package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RaceInfo {
    private final List<Car> carList = new ArrayList<>();
    private final int attemptCount;

    public RaceInfo(String[] carNames, String attemptCount) {
        validateInput(carNames, attemptCount);

        for (String carName : carNames) {
            Car car = new Car(carName);
            this.carList.add(car);
        }
        this.attemptCount = Integer.parseInt(attemptCount);

    }

    public List<Car> getCarList() {
        return carList;
    }

    public int getAttemptCount() {
        return attemptCount;
    }


    public void validateInput(String[] carNames, String attemptCount) {
        RaceInfoValidator.checkCarNameLength(carNames);
        RaceInfoValidator.isNameEmpty(carNames);
        RaceInfoValidator.hasUniqueName(carNames);
        RaceInfoValidator.hasMultipleCars(carNames);
        RaceInfoValidator.checkAttemptCount(attemptCount);
    }
}
