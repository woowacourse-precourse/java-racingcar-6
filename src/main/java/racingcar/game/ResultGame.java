package racingcar.game;

import racingcar.car.CarInfo;

import java.util.List;
import java.util.stream.Collectors;

public class ResultGame {
    private static int getMaxMoveCount(List<CarInfo> carList) {
        return carList.stream()
                .mapToInt(CarInfo::getMoveCount)
                .max()
                .orElse(0);
    }
}
