package racingcar.model;

import static racingcar.config.Constants.MOVE_THRESHOLD;
import static racingcar.config.Constants.RANGE_MAX;
import static racingcar.config.Constants.RANGE_MIN;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int moves;

    public Car(String name) {
        this.name = name;
        this.moves = 0;
    }

    public String getPosition() {
        String name = this.name;
        String position = "-".repeat(this.moves);
        String carStatus = String.format("%s : %s\n", name, position);

        return carStatus;
    }

    // TODO: Getter 제거, 다른 방법 모색
    public String getName() {
        return this.name;
    }

    public int getMoves() {
        return this.moves;
    }

    public void tryMove() {
        if (canMove()) {
            moves++;
        }
    }

    
    // 랜덤으로 뽑은 값이 임계값보다 큰지(이동해도 되는지) 판별
    private boolean canMove() {
        int pickedNumber = Randoms.pickNumberInRange(RANGE_MIN, RANGE_MAX);

        return pickedNumber > MOVE_THRESHOLD;
    }

}
