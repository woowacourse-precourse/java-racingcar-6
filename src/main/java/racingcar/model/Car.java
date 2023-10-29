package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int moves;

    public Car(String name) {
        this.name = name;
        this.moves = 0;
    }

    public String getPosition() {
        String name = this.name;
        String position = "-".repeat(this.moves);
        String carStatus = String.format("%s : %s\n", name, position);

        return carStatus;
    }

    // TODO: Getter 제거, 다른 방법 모색
    public String getName() {
        return this.name;
    }

    public int getMoves() {
        return this.moves;
    }

    public void tryMove() {
        if (canMove()) {
            moves++;
        }
    }


    private boolean canMove() {
        return (Randoms.pickNumberInRange(0, 9) > 3);
    }

}
