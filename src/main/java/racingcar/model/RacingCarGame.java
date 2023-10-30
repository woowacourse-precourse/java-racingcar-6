package racingcar.model;

import java.util.List;

public class RacingCarGame implements Game {
    private static final int criterion = 4;
    private final int attempts;
    private final List<Car> carList;

    public void goAhead(Car car, int randomNumber) {
        if (randomNumber >= criterion) {
            car.move();
        }
    }
}
