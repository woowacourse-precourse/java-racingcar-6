package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Racing {
    final static int GO_FORWARD = 1;


    public int generateNumber() {
        return Randoms.pickNumberInRange(1, 10) - 1;

    }

    public void startRacing(List<Car> carList) {
        for (Car car : carList) {
            int possibilityGo = generateNumber();
            if (possibilityGo >= 4) {
                car.carPosition += GO_FORWARD;
            }
        }
    }

}
