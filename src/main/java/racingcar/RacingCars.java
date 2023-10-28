package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import racingcar.dto.output.CarInfo;
import racingcar.dto.output.WinnerInfo;
import racingcar.racing.MoveStrategy;

public class RacingCars {
    private final List<Car> carList;
    private final MoveStrategy moveStrategy;

    public static RacingCars createCars(String[] names, MoveStrategy moveStrategy) {
        List<Car> carList = Arrays.stream(names)
                .map(Car::new)
                .toList();
        return new RacingCars(carList, moveStrategy);
    }

    private RacingCars(List<Car> carList, MoveStrategy moveStrategy) {
        this.carList = carList;
        this.moveStrategy = moveStrategy;
    }

    public void move() {
        carList.forEach(this::tryToMoveCar);
    }

    public List<CarInfo> getRoundResults() {
        return carList.stream()
                .map(Car::toCarInfo)
                .toList();
    }

    public WinnerInfo getWinner() {
        int winnerScore = findWinnerScore();

        List<String> names = carList.stream()
                .map(car -> car.getWinnerName(winnerScore))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();

        return Car.toWinnerInfo(names);
    }

    private void tryToMoveCar(Car car) {
        if (moveStrategy.isMovable()) {
            car.increaseMoveCount();
        }
    }


    private int findWinnerScore() {
        int maxMoveCount = 0;
        for (Car car : carList) {
            maxMoveCount = car.updateMax(maxMoveCount);
        }

        return maxMoveCount;
    }
}
