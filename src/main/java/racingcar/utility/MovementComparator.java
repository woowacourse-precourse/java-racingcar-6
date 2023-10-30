package racingcar.utility;

import java.util.Comparator;
import racingcar.domain.Car;

public class MovementComparator implements Comparator<Car> {
    @Override
    public int compare(final Car c1, final Car c2) {
        return Integer.compare(c2.getForwardCount(), c1.getForwardCount());
    }
}
