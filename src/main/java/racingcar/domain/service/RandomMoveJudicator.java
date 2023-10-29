package racingcar.domain.service;

public class RandomMoveJudicator {

    private final RandomGenerator randomGenerator;


    public RandomMoveJudicator(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    public boolean canMove() {
        return randomGenerator.generateNumber() >= 4;
    }

}
