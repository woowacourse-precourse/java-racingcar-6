package racingcar.controller;

import racingcar.domain.RacingCars;
import racingcar.utils.Converter;
import racingcar.view.Input;
import racingcar.view.Output;

public class RacingController {

    private final Output output = new Output();
    private final Input input = new Input();

    public void run() {
        RacingCars racingCars = makeRacingCars();
        int count = makeCount();
        race(racingCars, count);
        output.showWinners(racingCars.findWinners());
    }

    private RacingCars makeRacingCars() {
        output.showCarNamesInputMessage();
        return RacingCars.from(input.readCarNames());
    }

    private int makeCount() {
        output.showCountInputMessage();
        return Converter.toInt(input.readCount());
    }

    private void race(RacingCars racingCars, int count) {
        output.showResultMessage();
        for (int i = 0; i < count; i++) {
            output.showResult(racingCars.race());
        }
    }
}
