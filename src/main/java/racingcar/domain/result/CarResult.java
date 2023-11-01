package racingcar.domain.result;

import static racingcar.utils.RacingConfig.MOVED_HISTORY_MARK;

public class CarResult {
    private final String name;
    private final int distance;

    public CarResult(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public String getDistanceMark() {
        return MOVED_HISTORY_MARK.repeat(distance);
    }
}
