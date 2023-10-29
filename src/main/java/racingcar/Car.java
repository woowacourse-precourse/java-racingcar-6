package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int odometer;

    public String getName() {
        return name;
    }

    public Car(String name) {
        classInvariant(name);
        this.name = name;
        this.odometer = 0;
    }

    public int getOdometer() {
        return odometer;
    }

    public void moveForward() {
        if (isMovable()) {
            this.odometer++;
        }
    }

    private boolean isMovable() {
        final int THRESHHOLD = 4;
        final int LOWER_BOUND = 0;
        final int UPPER_BOUND = 9;
        return Randoms.pickNumberInRange(LOWER_BOUND, UPPER_BOUND) >= THRESHHOLD;
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
