package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.dto.output.CarInfo;
import racingcar.dto.output.WinnerInfo;
import racingcar.common.strategy.MoveStrategy;

public class RacingCars {
    private final List<Car> cars;
    private final MoveStrategy moveStrategy;

    // 자동차 생성
    public static RacingCars createCars(String[] names, MoveStrategy moveStrategy) {
        List<Car> cars = Arrays.stream(names)
                .map(Car::new)
                .toList();
        return new RacingCars(cars, moveStrategy);
    }

    private RacingCars(List<Car> cars, MoveStrategy moveStrategy) {
        this.cars = cars;
        this.moveStrategy = moveStrategy;
    }

    // 자동차 이동
    public void moveCars() {
        cars.forEach(this::moveCarIfPossible);
    }

    // 라운드 결과
    public List<CarInfo> getRoundResults() {
        return cars.stream()
                .map(Car::toCarInfo)
                .toList();
    }

    // 승자 정보
    public WinnerInfo determineWinnerInfo() {
        int maxDistance = calculateMaxDistance();
        List<String> winnerNames = identifyWinners(maxDistance);
        return new WinnerInfo(winnerNames);
    }

    // 이동 가능하면 자동차 이동
    private void moveCarIfPossible(Car car) {
        if (moveStrategy.isMovable()) {
            car.increaseDistance();
        }
    }

    // 최대 이동 거리
    private int calculateMaxDistance() {
        int maxDistance = 0;
        for (Car car : cars) {
            maxDistance = car.calculateMaxDistance(maxDistance);
        }
        return maxDistance;
    }

    // 승자 확인
    private List<String> identifyWinners(int maxDistance) {
        List<String> winnerNames = new ArrayList<>();
        for (Car car : cars) {
            car.addWinnerIfEqual(maxDistance, winnerNames);
        }
        return winnerNames;
    }
}
