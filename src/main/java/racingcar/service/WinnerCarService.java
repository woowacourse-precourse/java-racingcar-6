package racingcar.service;

import java.util.List;

import racingcar.domain.Cars;
import racingcar.domain.WinnerCar;

public class WinnerCarService {
    public WinnerCar createWinnerCar(Cars cars) {
        return WinnerCar.create(cars);
    }

    public List<String> getWinnerNames(WinnerCar winnerCar) {
        return winnerCar.getName();
    }
}
