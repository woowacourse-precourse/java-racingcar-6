package racingcar.io.input;

import racingcar.model.Cars;

public class InputManager {

    private final InputView inputView;
    private final InputMapper inputMapper;

    public InputManager(InputView inputView, InputMapper inputMapper) {
        this.inputView = inputView;
        this.inputMapper = inputMapper;
    }

    public Cars inputCarNames() {
        String carNames = inputView.inputCarNames();
        return inputMapper.toCars(carNames);
    }

    public int inputAttemptCount() {
        String attemptCount = inputView.inputAttemptCount();
        return inputMapper.toInt(attemptCount);
    }

}
