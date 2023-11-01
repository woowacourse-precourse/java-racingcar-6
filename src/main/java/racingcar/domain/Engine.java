package racingcar.domain;

public class Engine {
    public boolean isMovingForward() {
        final Judgement judgement = new Judgement();
        final NumberGenerator generator = new NumberGenerator();

        int randomNumber = generator.createRandomNumber();
        return judgement.isFourOrMore(randomNumber);
    }
}
