package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

public class GameService {
    private static final String CAR_MOVEMENT_SYMBOL = "-";
    private static final String CAR_NAME_FRAME = " : ";
    private static final int RANDOM_NUMBER_RANGE_START = 0;
    private static final int RANDOM_NUMBER_RANGE_END = 9;
    private static final int CONDITION_CAR_MOVEMENT_NUMBER = 4;
    private int gameWinnerPosition = 0;

    public void move(Car car) {
        moveForward(car);
        StringBuilder moveCount = new StringBuilder();
        for (int i = 0; i < car.getPosition(); i++) {
            moveCount.append(CAR_MOVEMENT_SYMBOL);
        }
        System.out.println(car.getName() + CAR_NAME_FRAME + moveCount);
    }

    public void moveForward(Car car) {
        if (isMoveForward()) {
            car.plusMoveForward();
        }
    }

    public void getMaxPosition(List<Car> cars) {
        for (Car car : cars) {
            findMaxPosition(car);
        }
    }

    public List<String> findGameWinner(List<Car> cars) {
        return cars
                .stream()
                .filter(car -> gameWinnerPosition == car.getPosition())
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private boolean isMoveForward() {
        int randomNumber = Randoms.pickNumberInRange(RANDOM_NUMBER_RANGE_START, RANDOM_NUMBER_RANGE_END);

        return randomNumber >= CONDITION_CAR_MOVEMENT_NUMBER;
    }

    private void findMaxPosition(Car cars) {
        if (gameWinnerPosition < cars.getPosition()) {
            gameWinnerPosition = cars.getPosition();
        }
    }
}
