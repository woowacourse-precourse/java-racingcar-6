package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public record CarGarage(List<Car> cars) {

    public List<Car> findWinner() {
        int maxPosition = getMaxPosition(cars);
        return cars.stream()
                .filter(it -> it.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private int getMaxPosition(List<Car> cars) {
        int max = 0;
        for (Car car : cars) {
            int position = car.getPosition();
            if (position > max) {
                max = position;
            }
        }
        return max;
    }
}
