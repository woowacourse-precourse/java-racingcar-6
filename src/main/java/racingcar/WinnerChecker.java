package racingcar;

import java.util.List;

public class WinnerChecker {
    private final String NO_MOVEMENT_DURING_RACE = "경주 중 이동한 자동차가 없습니다.";
    private final String CANNOT_FIND_WINNER = "우승자를 찾을 수 없습니다.";
    private final Integer INITIAL_POSITION = 0;

    public List<String> getWinnerList(List<Car> carList) {
        return carList.stream().filter(car -> car.getPosition() == getMaxPosition(carList)).map(Car::getName).toList();
    }

    private int getMaxPosition(List<Car> carList) {
        int maxPosition = carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalArgumentException(CANNOT_FIND_WINNER));

        validateMaxIsInitialPosition(maxPosition);
        return maxPosition;
    }

    private void validateMaxIsInitialPosition(int maxPosition) {
        if (maxPosition == INITIAL_POSITION) {
            throw new IllegalArgumentException(NO_MOVEMENT_DURING_RACE);
        }
    }
}
