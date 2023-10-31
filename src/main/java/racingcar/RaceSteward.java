package racingcar;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.vo.CarList;

public class RaceSteward {

    public CarList nominateWinners(final CarList carList) {
        final int maxForwardCount = carList.getMaxForwardCount();

        List<Car> winners = carList.cars().stream()
                .filter(car -> car.getForwardCount() == maxForwardCount)
                .toList();

        return CarList.of(winners);
    }

}
