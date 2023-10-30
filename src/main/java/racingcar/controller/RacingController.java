package racingcar.controller;

import racingcar.domain.RacingCars;
import racingcar.utils.Converter;
import racingcar.view.Input;
import racingcar.view.Output;

public class RacingController {

    private final Output output = new Output();
    private final Input input = new Input();

    public void run() {
        output.showCarNamesInputMessage();
        String carNames = input.readCarNames();
        RacingCars racingCars = RacingCars.from(carNames);

        output.showCountInputMessage();
        int count = Converter.toInt(input.readCount());

        output.showResultMessage();
        for (int i = 0; i < count; i++) {
            output.showResult(racingCars.race());
        }

        output.showWinners(racingCars.findWinners());
    }
}
