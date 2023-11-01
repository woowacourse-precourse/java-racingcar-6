package racingcar.domain;

import java.util.List;

public interface GameControllable {
    void moveOrNot(Car car, int randomNumber);

    void play(List<Car> carList, int attemptCount, int[] randomNumberList);
}
