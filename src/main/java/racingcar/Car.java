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

    public String showCurrentDisplacement() {
        StringBuilder stringBuilder = new StringBuilder(name).append(" : ");
        for (int i = 0; i < displacement; i++) {
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }

    public int getDisplacement() {
        return displacement;
    }

    private boolean isAbleToProceed() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber > 3;
    }

    private void proceed() {
        displacement++;
    }
}
