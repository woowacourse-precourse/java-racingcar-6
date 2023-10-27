package racingcar;

public class Car {
    private long position;
    private Engine engine;

    public void moveCar() {
        if (canMove()) {
            this.position++;
        }
    }

    private boolean canMove() {
        int power = startEngine();
        return power >= 4;
    }

    private int startEngine() {
        return engine.generateRandomNumber();
    }
}
