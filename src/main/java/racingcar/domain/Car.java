package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int advanceCount;
    private final StringBuilder advanceCountMark;

    public Car(String name) {
        this.name = name;
        this.advanceCount = 0;
        this.advanceCountMark = new StringBuilder();
    }

    public String getName() {
        return name;
    }

    public int getAdvanceCount() {
        return advanceCount;
    }

    public String getAdvanceCountMark() {
        changeAdvanceCount();
        return advanceCountMark.toString();
    }

    private void changeAdvanceCount() {
        int number = Randoms.pickNumberInRange(0, 9);
        if (number >= 4) {
            advanceCount++;
            advanceCountMark.append("-");
        }
    }
}
