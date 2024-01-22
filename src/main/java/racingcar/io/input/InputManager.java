package racingcar.io.input;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import racingcar.model.Cars;

@Component
public class InputManager {

    private final InputView inputView;
    private final InputMapper inputMapper;

    @Autowired
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
