package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import racingcar.dto.output.RoundResultDTO;

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

    public List<String> getWinner() {
        int winnerScore = findWinnerScore();

        return carList.stream()
                .filter(car -> car.getMoveCount() == winnerScore)
                .map(Car::getName)
                .toList();
    }

    private int findWinnerScore() {
        return carList.stream()
                .map(Car::getMoveCount)
                .max(Comparator.naturalOrder())
                .orElseThrow(() -> new IllegalStateException("어떤 이유로 1등이 존재하지 않습니다."));
    }
}
