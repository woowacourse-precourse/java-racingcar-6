package racingcar.io.input;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import racingcar.model.Cars;

@Component
@RequiredArgsConstructor
public class InputManager {

    private final InputView inputView;
    private final InputMapper inputMapper;

    public Cars inputCarNames() {
        String carNames = inputView.inputCarNames();
        return inputMapper.toCars(carNames);
    }

    public int inputAttemptCount() {
        String attemptCount = inputView.inputAttemptCount();
        return inputMapper.toInt(attemptCount);
    }

}
