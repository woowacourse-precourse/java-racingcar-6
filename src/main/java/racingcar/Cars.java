package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Cars {
    private final List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public void updateForwardCar() {
        for (Car car : carList) {
            if(isForward(Randoms.pickNumberInRange(0, 9)))
                car.moveForward();
        }
    }

    private boolean isForward(int randomNumber) {
        return randomNumber >= 4;
    }

}
