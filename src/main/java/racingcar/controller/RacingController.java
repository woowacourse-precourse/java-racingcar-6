package racingcar.controller;

import static racingcar.utils.Validator.isNumber;
import static racingcar.utils.Validator.isValidLength;
import static racingcar.utils.Validator.isValidNameFormat;

import java.util.Arrays;
import racingcar.utils.Validator;
import racingcar.view.RacingView;
import racingcar.view.enums.RacingMessage;

public class RacingController {
    RacingView racingView;

    public RacingController(RacingView racingView) {
        this.racingView = racingView;
    }

    public void start() {
        play();
    }

    private void play() {
        racingView.DisplayMessage(RacingMessage.ASK_FOR_CAR_NAME);
        String inputName = racingView.readInput();
        String[] carNames = getUserInputName(inputName);

        racingView.DisplayMessage(RacingMessage.ASK_FOR_ROUNDS);
        String inputRound = racingView.readInput();
        int round = getUserInputNumber(inputRound);
    }

    private String[] getUserInputName(String inputName) {
        isValidNameFormat(inputName);
        return Arrays.stream(inputName.split(","))
                .map(String::trim)
                .peek(Validator::isValidLength)
                .toArray(String[]::new);
    }

    private int getUserInputNumber(String inputNumber) {
        isNumber(inputNumber);
        return Integer.parseInt(inputNumber);
    }
}
