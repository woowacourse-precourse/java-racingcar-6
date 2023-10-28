package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static racingcar.util.StringUtils.splitByComma;

public class Cars {
    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;
    private static final int CAN_MOVE_STANDARD = 4;

    private final List<Car> cars = new ArrayList<>();

    public Cars(String carNames) {
        String[] carList = splitByComma(carNames, ",");
        for (String carName : carList) {
            cars.add(new Car(carName));
        }
    }

    // 차 들이 모두 움직이기 때문에 Cars에 넣음
    private void moveByRandomNumber() {
        for (Car car : cars) {
            if()
        }
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
    }
}
