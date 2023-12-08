package racingcar.model.car;

import java.util.Comparator;

public interface OrderStrategy extends Comparator<Car> {
    @Override
    int compare(Car o1, Car o2);
}
