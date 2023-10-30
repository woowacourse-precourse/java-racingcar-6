package racingcar.domain.core.car;

import java.util.Iterator;
import java.util.List;
import racingcar.exceptions.runtime.NotFoundSourceException;

public class OnRaceCars implements Iterable<OnRaceCar> {

    private final List<OnRaceCar> cars;

    public OnRaceCars(List<OnRaceCar> cars) {
        this.cars = cars;
    }

    @Override
    public Iterator<OnRaceCar> iterator() {
        return cars.iterator();
    }

    public Long getPosition(OnRaceCar car) {
        return getPosition((BasicCar) car);
    }

    public Long getPosition(BasicCar car) {
        return cars.stream()
            .filter(onRaceCar -> onRaceCar.equals(car))
            .map(OnRaceCar::getPosition)
            .findFirst()
            .orElseThrow(NotFoundSourceException::new);
    }
}
