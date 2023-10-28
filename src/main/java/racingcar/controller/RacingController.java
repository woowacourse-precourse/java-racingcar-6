package racingcar.controller;

import racingcar.domain.RacingCars;
import racingcar.view.Input;
import racingcar.view.Output;

public class RacingController {

    private static final String NUMBER_FORMAT_EXCEPTION = "숫자를 입력해야 합니다.";

    private final Output output = new Output();
    private final Input input = new Input();

    public void run() {
        output.showCarNamesInputMessage();
        String carNames = input.readCarNames();
        RacingCars racingCars = RacingCars.from(carNames);

        output.showCountInputMessage();
        int count = toInteger(input.readCount());

        output.showResultMessage();
        for (int i = 0; i < count; i++) {
            output.showResult(racingCars.race());
        }

        output.showWinners(racingCars.findWinners());
    }

    private int toInteger(String count) {
        try {
            return Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION);
        }
    }
}
