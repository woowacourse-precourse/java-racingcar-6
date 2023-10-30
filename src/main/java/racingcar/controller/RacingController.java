package racingcar.controller;

import static racingcar.utils.RacingConfig.NAME_SEPARATOR;
import static racingcar.utils.Validator.validIsNumber;
import static racingcar.utils.Validator.validNameFormat;

import java.util.Arrays;
import racingcar.domain.result.FinalResult;
import racingcar.model.RacingModel;
import racingcar.utils.Validator;
import racingcar.view.RacingView;
import racingcar.view.message.RacingMessage;

public class RacingController {
    private final RacingModel racingModel;
    private final RacingView racingView;

    public RacingController(RacingModel racingModel, RacingView racingView) {
        this.racingModel = racingModel;
        this.racingView = racingView;
    }

    public void start() {
        String[] carNames = readCarNames();
        int finalRound = readRoundNumber();

        FinalResult finalFinalResult = racingModel.startRacing(carNames, finalRound);

        displayResults(finalFinalResult);
    }

    private String[] readCarNames() {
        racingView.displayRacingMessage(RacingMessage.ASK_FOR_CAR_NAME);
        String inputCarNames = racingView.readInput();
        return parseCarNames(inputCarNames);
    }
    private String[] parseCarNames(String inputCarNames) {
        validNameFormat(inputCarNames);
        return Arrays.stream(inputCarNames.split(NAME_SEPARATOR))
                .map(String::trim)
                .distinct()
                .peek(Validator::validLength)
                .toArray(String[]::new);
    }

    private int readRoundNumber() {
        racingView.displayRacingMessage(RacingMessage.ASK_FOR_ROUNDS);
        String inputRoundNumber = racingView.readInput();
        return parseRoundNumber(inputRoundNumber);
    }
    private int parseRoundNumber(String inputNumber) {
        validIsNumber(inputNumber);
        return Integer.parseInt(inputNumber);
    }

    private void displayResults(FinalResult finalFinalResult) {
        racingView.displayFinalResult(finalFinalResult);
        racingView.displayWinner(finalFinalResult);
    }
}
