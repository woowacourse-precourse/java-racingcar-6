package racingcar.game.director;

import java.util.ArrayList;
import java.util.List;
import racingcar.game.car.Car;

public record Round(List<Car> carList) {

    @Override
    public List<Car> carList() {
        return new ArrayList<>(carList);
    }
}
