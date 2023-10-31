package racingcar.dto;

import java.util.List;
import racingcar.model.Racing;

public class RacingStatus {

    private final List<CarInfo> carInfos;

    private RacingStatus(List<CarInfo> carInfos) {
        this.carInfos = carInfos;
    }

    public static RacingStatus from(Racing racing) {
        return new RacingStatus(racing.getCarInfoList());
    }

    public List<CarInfo> getCarInfos() {
        return carInfos;
    }
}
