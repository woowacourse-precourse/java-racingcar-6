package racingcar.domain;

/*
 *   자동차의 관한 정보를 담당
 * */

public class Car {
    
    private static final int MOVE_COUNT_INITIAL = 0;
    private String name;
    private int moveCount;

    public Car(String name) {
        this.name = name;
        this.moveCount = MOVE_COUNT_INITIAL;
    }

    public void move() {
        this.moveCount++;
    }
}
