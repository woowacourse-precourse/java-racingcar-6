package racingcar.domain;

public class Movable {
    private static final int STOP_NUMBER = 4;
    private final RandomNumberGenerator randomNumberGenerator;

    public Movable() {
        this.randomNumberGenerator = new RandomNumberGenerator();
    }

    public Movable(RandomNumberGenerator randomNumberGenerator){
        this.randomNumberGenerator = randomNumberGenerator;
    }
    public boolean canMove() {
        return STOP_NUMBER <= randomNumberGenerator.generate();
    }
}
