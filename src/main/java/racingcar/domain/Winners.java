package racingcar.domain;

import java.util.List;
import java.util.Objects;

public class Winners {
    private final List<Car> winners;
    private final Position maxPosition;

    public Winners(List<Car> cars) {
        this.maxPosition = new Position(getMaxPosition(cars));
        winners = cars.stream()
                .filter(car -> car.isWinner(maxPosition))
                .toList();
    }

    private int getMaxPosition(List<Car> cars) {
        return cars.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .orElse(0);
    }

    public List<Car> getCars() {
        return winners;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Winners winners1 = (Winners) o;
        return Objects.equals(winners, winners1.winners) && Objects.equals(maxPosition,
                winners1.maxPosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winners, maxPosition);
    }

    @Override
    public String toString() {
        return "Winners{" +
                "winners=" + winners +
                ", maxPosition=" + maxPosition +
                '}';
    }
}
