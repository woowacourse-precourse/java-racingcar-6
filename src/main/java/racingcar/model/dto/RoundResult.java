package racingcar.model.dto;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.gameinfo.CarInfo;

public class RoundResult {
    private final List<CarInfo> carInfos;

    public RoundResult(List<CarInfo> carInfos) {
        this.carInfos = carInfos;
    }

    public List<CarInfo> getCarInfos() {
        return new ArrayList<>(carInfos);
    }
}
