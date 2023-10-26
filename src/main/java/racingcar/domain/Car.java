package racingcar.domain;

public class Car {
    /*
     *   자동차의 이름과 이동거리를 저장하는 클래스
     * */
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
