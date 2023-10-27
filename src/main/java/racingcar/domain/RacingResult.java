package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingResult {
    private static final String JOIN_SEPARATOR = ", ";
    private final List<CarStatus> carStatuses;

    public RacingResult(List<CarStatus> carStatuses) {
        this.carStatuses = carStatuses;
    }

    public String getWinner() {
        return carStatuses.stream()
                .filter(car -> car.position() == getMaxPosition())
                .map(CarStatus::name)
                .collect(Collectors.joining(JOIN_SEPARATOR));
    }

    public List<CarStatus> getCarStatuses() {
        return Collections.unmodifiableList(carStatuses);
    }

    private int getMaxPosition() {
        return carStatuses.stream()
                .mapToInt(CarStatus::position)
                .max()
                .getAsInt();
    }
}
