package racingcar;

import java.util.List;

public class Game {
    private Cars cars;
    private Integer attempts;

    private Game(String[] carNames, Integer attempts) {
        this.cars = new Cars(carNames);
        validateAttempts(attempts);
        this.attempts = attempts;
    }

    private void validateAttempts(Integer attempts) {
        if (attempts <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public static Game create() {
        Writer.opening();
        String[] carNames = Reader.carNames();
        Writer.askAttempts();
        Integer attempts = Reader.attempts();
        return new Game(carNames, attempts);
    }

}
