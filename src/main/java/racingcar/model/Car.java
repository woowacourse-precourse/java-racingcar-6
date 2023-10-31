package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car implements Comparable<Car> {
    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 9;
    private static final int ADVANCE_VALUE = 4;

    private final String name;
    private int move = 0;

    public Car(final String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Car o) {
        return o.move - this.move;
    }

    public boolean isWinner(final int maxMove) {
        if (move >= maxMove)
            return true;

        return false;
    }

    public void doTurn() {
        int pickedNumber = Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);

        if (pickedNumber >= ADVANCE_VALUE) {
            this.move++;
        }
    }

    public String getNowMoveStatus() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" : ");

        for (int i = 0; i < move; i++) {
            sb.append("-");
        }
        sb.append("\n");

        return sb.toString();
    }

    public int getMove() {
        return this.move;
    }

    public String getName() {
        return this.name;
    }
}
