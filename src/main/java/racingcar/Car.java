package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int odometer;

    public Car(String name) {
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

    private String parseGraphic() {
        StringBuilder sb= new StringBuilder();
        for (int i = 1; i <= odometer; i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}
