package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int moves;

    public Car(String name) {
        this.name = name;
        this.moves = 0;
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

    // TODO: 출력은 View를 통해서만
    public void getPosition() {
        String name = this.name;
        String position = "-".repeat(this.moves);
        
        System.out.printf("%s : %s\n", name, position);
    }

    private boolean canMove() {
        return (Randoms.pickNumberInRange(0, 9) > 3);
    }

}
