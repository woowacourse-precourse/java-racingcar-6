package racingcar.io;

import racingcar.domain.RacingCars;

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
}
