package racingcar;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.vo.CarList;

public class RaceSteward {

    public List<String> nominateWinners(final CarList carList) {
        final int maxForwardCount = carList.getMaxForwardCount();

        return carList.cars().stream()
                .filter(car -> car.getForwardCount() == maxForwardCount)
                .map(Car::getName)
                .toList();
    }

}
