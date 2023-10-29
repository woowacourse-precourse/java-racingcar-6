package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int STANDARD_NUMBER = 4;
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void go(int random) {
        if(isBigger(random)) {
            position++;
        }
    }

    private boolean isBigger(int num) {
        return STANDARD_NUMBER <= num;
    }

}
