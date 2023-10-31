package racingcar.service;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class WinnerCheckService {

    public List<Car> getWinnersList(Cars cars) {
        int winnerPosition = cars.getWinnerPosition();
        return cars.getCarsByPosition(winnerPosition);
    }
}
