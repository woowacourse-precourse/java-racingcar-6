package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import racingcar.dto.output.RoundResultDTO;
import racingcar.dto.output.WinnerDTO;

public class RacingCars {
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int MOVABLE_THRESHOLD = 4;

    private final List<Car> carList;

    public static RacingCars createCars(String[] names) {
        List<Car> carList = Arrays.stream(names)
                .map(Car::new)
                .toList();
        return new RacingCars(carList);
    }

    private RacingCars(List<Car> carList) {
        this.carList = carList;
    }

    public void move() {
        carList.forEach(this::tryToMoveCar);
    }

    public List<RoundResultDTO> getRoundResults() {
        return carList.stream()
                .map(Car::toDTO)
                .toList();
    }

    private void tryToMoveCar(Car car) {
        if (isMovable()) {
            car.increaseMoveCount();
        }
    }

    private boolean isMovable() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER) >= MOVABLE_THRESHOLD;
    }

    public WinnerDTO getWinner() {
        int winnerScore = findWinnerScore();

        List<String> names = carList.stream()
                .map(car -> car.getWinnerName(winnerScore))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();

        return Car.toWinnerDTO(names);
    }

    private int findWinnerScore() {
        int maxMoveCount = 0;
        for (Car car : carList) {
            maxMoveCount = car.updateMax(maxMoveCount);
        }

        return maxMoveCount;
    }
}
