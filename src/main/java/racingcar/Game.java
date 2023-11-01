package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Game {
    private final Cars cars;

    public Game(String carNames) {
        cars = new Cars(carNames);
    }

    public Cars getCars() {
        return cars;
    }

    public void playRound() {
        moveCar();
    }

    public List<String> findWinners() {
        return cars.findWinners();
    }

    private void moveCar() {
        cars.toList().forEach(car -> car.moveOrNot(pickNumberInRange()));
    }

    private int pickNumberInRange() {
        return Randoms.pickNumberInRange(Constant.MINIMUM_RANDOM_NUMBER, Constant.MAXIMUM_RANDOM_NUMBER);
    }
}
