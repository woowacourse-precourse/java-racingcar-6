package racingcar.domain;

import java.util.Iterator;
import java.util.List;
import racingcar.utils.CustomCollections;

public class Cars implements Iterable<Car> {
    private final List<Car> carList;

    private Cars(List<Car> carList) {
        validateNotEmpty(carList);
        this.carList = carList;
    }

    public static Cars from(List<Car> cars) {
        return new Cars(cars);
    }

    public List<Car> getCarsWithMaxStep() {
        return CustomCollections.maxAll(carList);
    }

    private static void validateNotEmpty(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Iterator<Car> iterator() {
        return carList.iterator();
    }
}
