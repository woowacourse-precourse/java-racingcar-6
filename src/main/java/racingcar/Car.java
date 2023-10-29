package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int odometer;

    public Car(String name) {
        classInvariant(name);
        this.name = name;
        this.odometer = 0;
    }


    public void moveForward() {
        final int MINIMUM_CONDITION = 4;
        if (Randoms.pickNumberInRange(0, 9) >= MINIMUM_CONDITION) {
            this.odometer++;
        }
    }

    @Override
    public String toString() {
        String graphicOdometer = parseGraphic();
        return this.name + " : " + graphicOdometer;
    }

    private void classInvariant(String name) {
        checkCharacterLimit(name);
    }

    private String parseGraphic() {
        return "-".repeat(Math.max(0, odometer));
    }

    private void checkCharacterLimit(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다");
        }
    }
}
