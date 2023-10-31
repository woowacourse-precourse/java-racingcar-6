package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.CarInfo;

public class RacingRoundResult {
    private static final String NOT_AVAILABLE_CAR_LIST_EXCEPTION = "올바르지 않은 자동차 리스트입니다.";
    private final List<CarInfo> carInfos;

    public RacingRoundResult(List<CarInfo> carInfoList) {
        this.carInfos = carInfoList;
    }

    public List<CarInfo> getCarInfos() {
        return this.carInfos.stream()
                .map(carInfo -> new CarInfo(carInfo.name(), carInfo.position()))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<String> getWinners() {
        int maxPosition = getMaxPosition();
        return getSamePosition(maxPosition);
    }

    private List<String> getSamePosition(int maxPosition) {
        return this.carInfos.stream()
                .filter(carInfo -> carInfo.position() == maxPosition)
                .map(CarInfo::name)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return this.carInfos.stream()
                .mapToInt(CarInfo::position)
                .max()
                .orElseThrow(() -> new IllegalArgumentException(NOT_AVAILABLE_CAR_LIST_EXCEPTION));
    }
}
