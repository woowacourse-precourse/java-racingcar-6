package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Raching {
    static final CarManager carManager = new CarManager();
    static final int maximomMove = carManager.inputForCarMove();

    public void generateRandomNumber(ArrayList<Car> cars) {
        for (Car car : cars) {
            int pickNum = Randoms.pickNumberInRange(0,9);
            car.pickNumber = pickNum;
        }
    }
}
