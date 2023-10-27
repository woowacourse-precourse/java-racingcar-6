package racingcar;

public class Car {

    public final String name;
    private final Engine engine;
    private long totalMoveCount;

    public Car(String name, Engine engine) {
        this.name = name;
        this.engine = engine;
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
