package racingcar.domain;

import java.util.List;
import racingcar.vo.CarName;
import racingcar.vo.Cars;
import racingcar.vo.RoundCount;

public class Racing {
    private final Cars cars;
    private final RoundCount roundCount;

    public Racing(List<Car> carList, RoundCount roundCount) {
        this.roundCount = roundCount;
        this.cars = new Cars(carList);
    }

}