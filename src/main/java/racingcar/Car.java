package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int displacement;

    public Car(String name, int displacement) {
        this.name = name;
        this.displacement = displacement;
    }

    public void conductAction() {
        if (isAbleToProceed()) {
            proceed();
        }
    }

    private boolean isAbleToProceed() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber > 3;
    }

    private void proceed() {
        displacement++;
    }
}
