package racingcar;

import java.util.Comparator;
import racingcar.Model.Car;

public class CarComparator implements Comparator<Car> {


    //DESC order
    @Override
    public int compare(Car o1, Car o2) {
        if (o1.getDistance() < o2.getDistance()) {
            return 1;
        } else if (o1.getDistance() == o2.getDistance()) {
            return 0;
        }

        return -1;
    }
}
