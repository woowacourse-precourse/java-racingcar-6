package racingcar.controller;

import static racingcar.controller.constant.RaceConstant.CAR_NAME_INPUT_MESSAGE;
import static racingcar.controller.constant.RaceConstant.NUMBER_OF_ROUND_INPUT_MESSAGE;
import static racingcar.controller.constant.RaceConstant.RACE_RESULT_MESSAGE;
import static racingcar.controller.constant.RaceConstant.ROUND_RESULT_MESSAGE;

import racingcar.controller.dto.MessageDto;
import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.domain.wrapper.RaceRound;
import racingcar.service.RaceService;
import racingcar.service.RefereeService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RaceService raceService;
    private final RefereeService refereeService;

    public RaceController() {
        inputView = new InputView();
        outputView = new OutputView();
        refereeService = new RefereeService();
        raceService = new RaceService(refereeService);
    }

    public void race() {
        String carNames = getCarNames();
        Cars cars = raceService.createCars(carNames);
        String numberOfRound = getNumberOfRound();
        RaceRound raceRound = raceService.createRaceRound(numberOfRound);

        Race race = raceService.createRace(cars, raceRound);

        MessageDto raceResult = raceService.proceedRace(race);
        printRoundResult(raceResult);
        MessageDto winnerResult = refereeService.announceWinners(race);
        printWinners(winnerResult);
    }

    private String getCarNames() {
        outputView.printMessage(CAR_NAME_INPUT_MESSAGE);
        return inputView.readUserInput();
    }

    private String getNumberOfRound() {
        outputView.printMessage(NUMBER_OF_ROUND_INPUT_MESSAGE);
        return inputView.readUserInput();
    }

    private void printRoundResult(MessageDto raceResult) {
        outputView.printMessage(ROUND_RESULT_MESSAGE + raceResult.getMessage());
    }

    private void printWinners(MessageDto winnerResult) {
        outputView.printMessage(RACE_RESULT_MESSAGE + winnerResult.getMessage());
    }
}
