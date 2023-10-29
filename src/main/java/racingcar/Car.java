package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int STANDARD_NUMBER = 4;

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

    public String getCarStatus() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" : ");

        for(int i = 0; i < position; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

}
