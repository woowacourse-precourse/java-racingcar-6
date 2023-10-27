package racingcar.service;

import static java.util.stream.Collectors.toList;

import java.util.List;
import racingcar.domain.Car;

public class WinnerChecker {
    public static List<Car> findWinner(List<Car> carList) {
        int maxProgress = getMaxProgress(carList);
        return carList.stream()
                .filter(i -> i.getProgressToInt() == maxProgress)
                .collect(toList());
    }

    // TODO 2023 10 28 두 메서드 대신 하나의 스트림으로 구현할 방법 찾기
    private static int getMaxProgress(List<Car> carList) {
        return carList.stream()
                .mapToInt(Car::getProgressToInt)
                .max()
                .getAsInt();
    }
}
