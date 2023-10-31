package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GameManager {
    public void tryMoveCar(Car car) {
        if (makeRandomNumber() > 4) {
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
        return Randoms.pickNumberInRange(0, 9);
    }
}
