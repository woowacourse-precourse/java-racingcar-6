package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameService {
    private int carGameWinner = 0;

    public void move(Car car) {
        moveForward(car);
        StringBuilder moveCount = new StringBuilder();
        for (int i = 0; i < car.getPosition(); i++) {
            moveCount.append("-");
        }
        System.out.println(car.getCarName() + " : " + moveCount);
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
            if (carGameWinner == carInfo.getPosition()) {
                gameWinners.add(carInfo.getCarName());
            }
        }
        return gameWinners;
    }

    private void findMaxPosition(Car carInfo) {
        if (carGameWinner < carInfo.getPosition()) {
            carGameWinner = carInfo.getPosition();
        }
    }

    private boolean isMoveForward() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);

        return randomNumber >= 4;
    }
}
