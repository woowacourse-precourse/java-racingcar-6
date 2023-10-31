package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MAX_NUMBER_OF_RANDOM = 9;
    private static final int MIN_NUMBER_OF_RANDOM = 0;
    private static final int MIN_NUMBER_OF_MOVE = 4;

    private final String name;
    private int position = 0;
    private final StringBuffer report;

    public Car(String name) {
        this.name = name;
        this.report = new StringBuffer();
        this.report.append(name);
        this.report.append(" : ");
    }

    public void move() {
        if (Randoms.pickNumberInRange(MIN_NUMBER_OF_RANDOM, MAX_NUMBER_OF_RANDOM) >= MIN_NUMBER_OF_MOVE) {
            this.position++;
            this.report.append("-");
        }
    }

}
