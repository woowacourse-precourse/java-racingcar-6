package racingcar.io;

import racingcar.domain.RacingCars;
import racingcar.domain.TryCount;

public class InputManager {

    private final InputView inputView;
    private final InputMapper inputMapper;

    public InputManager(final InputView inputView, final InputMapper inputMapper) {
        this.inputView = inputView;
        this.inputMapper = inputMapper;
    }

    public RacingCars readRacingCarNames() {
        final String input = inputView.readRacingCarNames();
        return inputMapper.toRacingCars(input);
    }

    public TryCount readTryCount() {
        final String input = inputView.readTryCount();
        return inputMapper.toTryCount(input);
    }
}
