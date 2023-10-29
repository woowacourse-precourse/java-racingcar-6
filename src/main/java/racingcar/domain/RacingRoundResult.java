package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.CarInfo;

public class RacingRoundResult {
    public static final String NOT_AVAILABLE_CAR_LIST_EXCEPTION = "올바르지 않은 자동차 리스트입니다.";
    private final List<CarInfo> carInfoList;

    public RacingRoundResult(List<CarInfo> carInfoList) {
        this.carInfoList = carInfoList;
    }

    public List<CarInfo> getCarInfoList() {
        return this.carInfoList.stream()
                .map(carInfo -> new CarInfo(carInfo.name(), carInfo.position()))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<String> getWinners() {
        int maxPosition = carInfoList.stream()
                .mapToInt(CarInfo::position)
                .max()
                .orElseThrow(() -> new IllegalArgumentException(NOT_AVAILABLE_CAR_LIST_EXCEPTION));

        return carInfoList.stream()
                .filter(carInfo -> carInfo.position() == maxPosition)
                .map(CarInfo::name)
                .collect(Collectors.toList());
    }
}
