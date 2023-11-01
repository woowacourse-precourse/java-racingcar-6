package racingcar.Model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<Car> cars = new ArrayList<>();
    private int tryCount;

    public RacingGame(List<String> carNames, int tryCount) {
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        this.tryCount = tryCount;
    }

    public void playRound() {
        for (Car car : cars) {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            car.move(randomValue);
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getTryCount() {
        return tryCount;
    }

}
