package racingcar.domain;

public class Movable {
    private static final int STOP_NUMBER = 4;
    private final RandomGenerator randomGenerator;

    public Movable() {
        this.randomGenerator = new RandomGenerator();
    }

    public boolean canMove() {
        return STOP_NUMBER <= randomGenerator.generate();
    }
}
