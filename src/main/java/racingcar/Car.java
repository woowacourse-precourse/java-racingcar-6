package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private final int displacement;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int displacement) {
        this.name = name;
        this.displacement = displacement;
    }

    public Car conductAction() {
        if (isAbleToProceed()) {
            return proceed();
        }
        return this;
    }

    public String showCurrentDisplacement() {
        StringBuilder stringBuilder = new StringBuilder(name).append(" : ");
        for (int i = 0; i < displacement; i++) {
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }

    public String displayName() {
        return name;
    }

    public int getDisplacement() {
        return displacement;
    }

    private boolean isAbleToProceed() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber > 3;
    }

    private Car proceed() {
        return new Car(name, displacement + 1);
    }
}
