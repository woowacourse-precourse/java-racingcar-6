package racingcar.domain.service;

public class RandomMoveJudge {

    private final RandomGenerator randomGenerator;


    public RandomMoveJudge(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    public boolean canMove() {
        return randomGenerator.generateNumber() >= 4;
    }

}
