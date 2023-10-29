package racingcar.controller;

import static racingcar.utils.Validator.isNumber;
import static racingcar.utils.Validator.isValidNameFormat;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.RacingFinalResult;
import racingcar.domain.RacingRoundResult;
import racingcar.model.RacingModel;
import racingcar.utils.Validator;
import racingcar.view.RacingView;
import racingcar.view.enums.RacingMessage;

public class RacingController {
    private RacingModel racingModel;
    private RacingView racingView;

    public RacingController(RacingModel racingModel, RacingView racingView) {
        this.racingModel = racingModel;
        this.racingView = racingView;
    }

    public void play() {

        String[] carNames = readCarNames();
        int round = readRoundNumber();

        RacingFinalResult racingResults = racingModel.proceed(carNames, round);
        displayResult(racingResults);
        displayWinner(racingResults);
    }

    private String[] readCarNames() {
        racingView.displayRacingMessage(RacingMessage.ASK_FOR_CAR_NAME);
        String inputName = racingView.readInput();
        return parseCarNames(inputName);
    }

    private int readRoundNumber() {
        racingView.displayRacingMessage(RacingMessage.ASK_FOR_ROUNDS);
        String inputRound = racingView.readInput();
        return parseRoundNumber(inputRound);
    }

    private String[] parseCarNames(String inputName) {
        isValidNameFormat(inputName);
        return Arrays.stream(inputName.split(","))
                .map(String::trim)
                .distinct()
                .peek(Validator::isValidLength)
                .toArray(String[]::new);
    }

    private int parseRoundNumber(String inputNumber) {
        isNumber(inputNumber);
        return Integer.parseInt(inputNumber);
    }

    private void displayResult(RacingFinalResult roundResults){
        racingView.displayRacingMessage(RacingMessage.RACING_RESULT);
        racingView.displayResults(roundResults.getRoundResults());
    }

    private void displayWinner(RacingFinalResult racingResults) {
        racingView.displayWinnerMessage(racingResults.getWinnersName());
    }
}
