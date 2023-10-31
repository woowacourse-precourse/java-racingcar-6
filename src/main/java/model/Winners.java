package model;

import java.util.List;
import java.util.stream.Collectors;

/**
 * packageName    : model
 * fileName       : Winners
 * author         : qkrtn_ulqpbq2
 * date           : 2023-10-30
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-10-30        qkrtn_ulqpbq2       최초 생성
 */
public class Winners {

    private static final int MIN_POSITION = 0;

    private final List<Car> winners;
    private final int maxPosition;

    public Winners(List<Car> cars) {
        maxPosition = getMaxPosition(cars);
        winners = cars.stream().filter(car -> car.getPosition() == maxPosition).collect(Collectors.toList());
    }

    public int getMaxPosition(List<Car> cars) {
        return cars.stream().mapToInt(Car::getPosition).max().orElse(MIN_POSITION);
    }

    public List<String> getNames() {
        return winners.stream().map(Car::getName).collect(Collectors.toList());
    }
}
