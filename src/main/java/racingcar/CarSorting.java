package racingcar;

import java.util.Comparator;

public class CarSorting implements Comparator<Car> {
    @Override
    public int compare(Car before, Car current) {
        int beforeCount = before.getMovingCount();
        int currentCount = current.getMovingCount();

        return Integer.compare(currentCount, beforeCount);
    }
}
