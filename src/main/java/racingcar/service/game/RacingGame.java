package racingcar.service.game;

import racingcar.domain.Cars;
import racingcar.service.input.Input;
import racingcar.service.input.InputView;

public class RacingGame implements GameInterface{
    private final Input input;
    public RacingGame() {
        this.input = new InputView();
    }

    @Override
    public void play() {
        Cars.of(input.getCarInput());
        
    }


}
