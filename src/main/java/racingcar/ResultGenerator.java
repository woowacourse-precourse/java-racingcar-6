package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class ResultGenerator {
    private static final int MOVE_THRESHOLD = 4;

    public void generateResult(List<String[]> cars) {
        for (int i = 0; i < cars.size(); i ++) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (determineMoveOrStop(randomNumber)) {
                moveCar(cars, i);
            }
            System.out.println(cars.get(i)[0] + " : " + cars.get(i)[1]);
        }
        System.out.println();
    }

    private boolean determineMoveOrStop(int randomNumber) {
        if (randomNumber >= MOVE_THRESHOLD) {
            return true;
        }
        return false;
    }

    private void moveCar(List<String[]> cars, int index) {
        cars.get(index)[1] += "-";
    }
}
