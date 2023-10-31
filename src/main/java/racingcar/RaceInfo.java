package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RaceInfo {
    private List<Car> carList = new ArrayList<>();

    private int attemptCount; // 이거 int로 고칠지

    public List<Car> getCarList() {
        return carList;
    }

    public int getAttemptCount() {
        return attemptCount;
    }

    public RaceInfo(String[] carNames, String attemptCount) {
        validateInput(carNames, attemptCount);
        for (String carName : carNames) {
            Car car = new Car(carName);
            this.carList.add(car);
        }
        this.attemptCount = Integer.parseInt(attemptCount);

    }

    public void validateInput(String[] carNames, String attemptCount) {
        RaceInfoValidator.checkCarNameLength(carNames);
        RaceInfoValidator.hasMultipleCarNames(carNames);
        RaceInfoValidator.checkAttemptCount(attemptCount);
    }
}
