package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final static String MOVING_MARK = "-";
    private final static int MOVE_CONDITION = 4;
    private final static int MIN_VALUE = 0;
    private final static int MAX_VALUE = 9;
    private final String name;
    private int move;

    public Car(String name) {
        this.name = name;
        this.move = 0;
    }

    public int getMove() {
        return move;
    }

    public String getName() {
        return name;
    }

    public void moveCar() {
        if (makeRandomNumber() >= MOVE_CONDITION) {
            move++;
        }
    }

    private int makeRandomNumber() {
        return Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
    }

    private String getMoveMark() {
        return MOVING_MARK.repeat(this.move);
    }

    @Override
    public String toString() {
        return String.format("%s : %s", name, getMoveMark());
    }
}
