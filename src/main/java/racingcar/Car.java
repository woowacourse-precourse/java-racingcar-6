package racingcar;

public class Car {
    private long position;

    public void moveCar() {
        if (canMove()) {
            this.position++;
        }
    }

    private boolean canMove() {
        int power = runEngine();
        return power >= 4;
    }
}
