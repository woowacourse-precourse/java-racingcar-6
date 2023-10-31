package racingcar.game;

import java.util.List;

public class GameArgument {

    private final List<String> carNames;
    private final String attemptInput;

    public GameArgument(List<String> carNames, String attemptInput) {
        this.carNames = carNames;
        this.attemptInput = attemptInput;
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public String getAttemptInput() {
        return attemptInput;
    }
}
