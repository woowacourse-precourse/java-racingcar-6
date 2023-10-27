package racingcar;

public class RacingCarGameImpl implements RacingCarGame {

    @Override
    public void startGame() {
        Input input = new InputImpl();
        input.carName();
        input.attemptsNumber();
    }

}
