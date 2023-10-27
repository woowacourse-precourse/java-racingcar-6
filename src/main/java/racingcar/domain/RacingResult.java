package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.CarStatusDto;

public class RacingResult {
    private static final String JOIN_SEPARATOR = ", ";
    private final List<CarStatusDto> carStatuses;

    public RacingResult(List<CarStatusDto> carStatuses) {
        this.carStatuses = carStatuses;
    }

    public String getWinner() {
        return carStatuses.stream()
                .filter(car -> car.position() == getMaxPosition())
                .map(CarStatusDto::name)
                .collect(Collectors.joining(JOIN_SEPARATOR));
    }

    public List<CarStatusDto> getCarStatuses() {
        return Collections.unmodifiableList(carStatuses);
    }

    private int getMaxPosition() {
        return carStatuses.stream()
                .mapToInt(CarStatusDto::position)
                .max()
                .getAsInt();
    }
}
