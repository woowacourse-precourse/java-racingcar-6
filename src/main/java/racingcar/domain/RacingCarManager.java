package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCarManager {

    private final List<Car> carList = new ArrayList<>();

    public RacingCarManager(List<String> carNames) {
        generateCarListWithCarNames(carNames);
    }

    private void generateCarListWithCarNames(List<String> carNames) {
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
    }

    public void playRacingGame() {
        for (Car car : carList) {
            car.moveOrStop();
        }
    }

}
