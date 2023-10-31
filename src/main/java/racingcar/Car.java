package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

class Car {
    private final String name;
    private int move = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return move;
    }

    public String getMove() {
        return "-".repeat(move);
    }

    public void tryMove() {
        int randomValue = Randoms.pickNumberInRange(0, 9);
        if (randomValue >= 4) {
            move++;
        }
    }
}
