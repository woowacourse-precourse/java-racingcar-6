package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Car implements Comparable<Car> {
    String carName;
    List<String> movement = new ArrayList<>();
    int forwardMovementNumber = movement.size();
    private int movementRandomNumber = Randoms.pickNumberInRange(0, 9);

    public void decideAction() {
        if (movementRandomNumber >= 4) {
            movement.add("-");
        }
    }

    @Override
    public int compareTo(Car car) {
        if (this.forwardMovementNumber > car.forwardMovementNumber) {
            return 1;
        } return -1;
    }
}
