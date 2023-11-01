package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private final static int MOVE_CONDITION = 4;
    private final static int MIN_VALUE = 0;
    private final static int MAX_VALUE = 9;

    public void tryMoveCar(Car car) {
        if (makeRandomNumber() >= MOVE_CONDITION) {
            car.moveCar();
        }
    }

    public List<String> getWinnerNameList(int winMove, Cars cars) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            if (cars.getCarInIndex(i).getMove() == winMove) {
                result.add(cars.getCarInIndex(i).getName());
            }
        }
        return result;
    }

    private int makeRandomNumber() {
        return Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
    }
}
