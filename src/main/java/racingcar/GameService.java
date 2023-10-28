package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class GameService {
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

    private boolean isMoveForward() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);

        return randomNumber >= 4;
    }
}
