package racingcar.domain;

import java.util.List;

public interface GameControllable {
    public void moveOrNot(Car car, int randomNumber);

    public void play(List<Car> carList, int attemptCount, int[] randomNumberList);

}
