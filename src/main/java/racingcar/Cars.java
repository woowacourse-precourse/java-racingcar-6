package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Cars {
    List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public void calculateMoveCount() {
        for (Car car : carList) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                car.increaseMoveCount();
            }
        }
    }

    public void printMoveCount() {
        carList.forEach(car -> System.out.println(car.getMoveCount()));
    }
}
