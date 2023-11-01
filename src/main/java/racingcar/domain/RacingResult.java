package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.CarStatusDto;
import racingcar.enums.Separator;

public class RacingResult {
    private List<CarStatusDto> carStatuses;

    public RacingResult(List<CarStatusDto> carStatuses) {
        this.carStatuses = carStatuses;
    }

    public String findWinner() {
        return carStatuses.stream()
                .filter(car -> car.position() == getMaxPosition())
                .map(CarStatusDto::name)
                .collect(Collectors.joining(Separator.JOIN_SEPARATOR.toString()));
    }

    private int getMaxPosition() {
        return carStatuses.stream()
                .mapToInt(CarStatusDto::position)
                .max()
                .getAsInt();
    }

    public List<CarStatusDto> getCarStatuses() {
        return Collections.unmodifiableList(carStatuses);
    }
}
