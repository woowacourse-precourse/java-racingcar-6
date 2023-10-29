package racingcar.domain;

import java.util.List;

public class RaceStatus {
    private final List<CarStatus> carStatuses;

    public RaceStatus(List<CarStatus> carStatuses) {
        this.carStatuses = carStatuses;
    }
}
