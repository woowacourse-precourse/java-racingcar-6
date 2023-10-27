package racingcar;

public class Car {

    public final String name;
    private long totalMoveCount;
    private Engine engine;

    public Car(String name) {
        this.name = name;
    }

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
