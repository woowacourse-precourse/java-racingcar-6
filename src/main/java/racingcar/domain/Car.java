package racingcar.domain;

import static racingcar.constant.SystemConstant.CAR_FORWARD_LIMIT_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.StringJoiner;

public class Car {
    private final String carName;
    private final StringBuilder forward;

    public Car(String carName) {
        this.carName = carName;
        this.forward = new StringBuilder();
    }

    public void isForward() {
        int random = Randoms.pickNumberInRange(0, 9);

        if (random >= CAR_FORWARD_LIMIT_NUMBER) {
            this.forward.append("-");
        }
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(" ");

        stringJoiner.add(this.carName);
        stringJoiner.add(":");
        stringJoiner.add(this.forward.toString());

        return stringJoiner.toString();
    }

    public int getForwardSize() {
        return this.forward.length();
    }

    public String getCarName() {
        return this.carName;
    }
}
