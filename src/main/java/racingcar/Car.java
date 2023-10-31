package racingcar;

public class Car {
    private String name;
    private int position;

    public void move() {
        if (GameUtil.shouldMove()) {
            this.position++;
        }
    }
}
