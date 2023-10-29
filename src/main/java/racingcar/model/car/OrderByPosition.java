package racingcar.model.car;

public class OrderByPosition implements OrderStrategy {

    @Override
    public int compare(Car o1, Car o2) {
        return o1.currentPosition.compareTo(o2.currentPosition);
    }
}
