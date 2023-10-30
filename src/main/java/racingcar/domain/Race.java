package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.util.RacingUtils;

public class Race {
    List<Car> racingCar = new ArrayList<>();;

    public Race(List<String> carNameList) {
        for (var carName : carNameList) {
            racingCar.add(new Car(carName));
        }
    }

    public void raincingCar() {
        racingCar.stream().forEach(car -> car.setPosition(RacingUtils.movingCar()));
    }

    public List<Car> getRacingCar() {
        return racingCar;
    }
}
