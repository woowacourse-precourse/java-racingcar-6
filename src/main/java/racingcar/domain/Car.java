package racingcar.domain;

import static racingcar.constant.RacingConstant.END_INCLUSIVE;
import static racingcar.constant.RacingConstant.PROCEED_THRESHOLD;
import static racingcar.constant.RacingConstant.START_INCLUSIVE;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String name;
    private int movedDistance;

    public Car(String name, int movedDistance) {
        this.name = name;
        this.movedDistance = movedDistance;
    }

    public void race() {
        int randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE.getConstant(), END_INCLUSIVE.getConstant());
        if (isProceed(randomNumber)) {
            this.movedDistance++;
        }
    }

    private boolean isProceed(int randomNumber) {
        return randomNumber >= PROCEED_THRESHOLD.getConstant();
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", movedDistance=" + movedDistance +
                '}';
    }
}
