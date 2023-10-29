package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameService {
    private static final String CAR_MOVEMENT = "-";
    private static final String CAR_NAME_FRAME = " : ";
    private static final int RANDOM_NUMBER_RANGE_START = 0;
    private static final int RANDOM_NUMBER_RANGE_END = 9;
    private static final int CONDITION_CAR_MOVEMENT_NUMBER = 4;
    private int gameWinnerPosition = 0;

    public void move(Car car) {
        moveForward(car);
        StringBuilder moveCount = new StringBuilder();
        for (int i = 0; i < car.getPosition(); i++) {
            moveCount.append(CAR_MOVEMENT);
        }
        System.out.println(car.getCarName() + CAR_NAME_FRAME + moveCount);
    }

    public void moveForward(Car car) {
        if (isMoveForward()) {
            car.plusMoveForward();
        }
    }

    public void getMaxPosition(List<Car> carInfos) {
        for (Car carInfo : carInfos) {
            findMaxPosition(carInfo);
        }
    }

    public List<String> findGameWinner(List<Car> carInfos) {
        List<String> gameWinners = new ArrayList<>();
        for (Car carInfo : carInfos) {
            if (gameWinnerPosition == carInfo.getPosition()) {
                gameWinners.add(carInfo.getCarName());
            }
        }
        return gameWinners;
    }

    private void findMaxPosition(Car carInfo) {
        if (gameWinnerPosition < carInfo.getPosition()) {
            gameWinnerPosition = carInfo.getPosition();
        }
    }

    private boolean isMoveForward() {
        int randomNumber = Randoms.pickNumberInRange(RANDOM_NUMBER_RANGE_START, RANDOM_NUMBER_RANGE_END);

        return randomNumber >= CONDITION_CAR_MOVEMENT_NUMBER;
    }
}
