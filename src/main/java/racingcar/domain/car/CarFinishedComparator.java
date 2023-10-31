package racingcar.domain.car;

import java.util.Comparator;

public final class CarFinishedComparator implements Comparator<CarFinished> {

    @Override
    public int compare(CarFinished o1, CarFinished o2) {
        return o2.coordinate.subtract(o1.coordinate);
    }
}
