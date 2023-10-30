package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MIN_MOVABLE_NUMBER = 4;
    private static final int START_RANGE = 0;
    private static final int END_RANGE = 9;

    private String name;
    private int location;

    public Car(String name) {
        this.name = name;
        this.location = 0;
    }

    public String getName() {
        return name;
    }

    /**
     * try move forward, and return whether this instance move or not
     *
     * @return if this instance move true, else false
     */
    public boolean isMove() {
        if (canGo()) {
            this.location++;
            return true;
        }
        return false;
    }

    private boolean canGo() {
        int randomNum = Randoms.pickNumberInRange(START_RANGE, END_RANGE);
        return randomNum >= MIN_MOVABLE_NUMBER;
    }

    /**
     * @return round result using name and location
     */
    public String getRoundResult() {
        StringBuilder sb = new StringBuilder(name);
        sb.append(" : ");
        for (int i = 0; i < location; i++) {
            sb.append("-");
        }

        return sb.toString();
    }
}
