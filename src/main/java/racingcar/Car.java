package racingcar;

public class Car {
    private long totalMoveCount;
    private Engine engine;

    public void moveCar() {
        if (canMove()) {
            this.totalMoveCount++;
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
