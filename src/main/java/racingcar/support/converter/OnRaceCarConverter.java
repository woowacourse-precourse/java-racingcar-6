package racingcar.support.converter;

import java.util.List;
import racingcar.domain.core.car.OnRaceCar;
import racingcar.domain.core.car.OnRaceCars;
import racingcar.domain.system.manager.position.SavedCarPosition;

public class OnRaceCarConverter {

    private OnRaceCarConverter() {
    }

    public static OnRaceCar from(SavedCarPosition car) {
        return new OnRaceCar(car.getSavedCar().getCar(), car.getPosition());
    }

    public static OnRaceCars from(List<SavedCarPosition> cars) {
        return new OnRaceCars(cars.stream().map(OnRaceCarConverter::from).toList());
    }
}
