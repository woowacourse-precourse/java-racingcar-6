package racingcar.dto;

import java.util.Collections;
import java.util.List;

public class RaceStatus {
    private final List<CarStatus> carStatuses;

    public RaceStatus(List<CarStatus> carStatuses) {
        this.carStatuses = carStatuses;
    }

    public List<CarStatus> getCarStatuses() {
        return Collections.unmodifiableList(carStatuses);
    }
}
