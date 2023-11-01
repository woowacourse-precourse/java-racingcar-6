package racingcar.controller;

import java.util.List;
import racingcar.dto.OneGameResultsDto;
import racingcar.service.RacingGameService;
import racingcar.service.domain.CarEngine;
import racingcar.service.domain.RacingCars;
import racingcar.utils.GameUtil;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final OutputView outputView;
    private final InputView inputView;
    private final RacingGameService racingGameService;
    private final CarEngine carEngine;

    public GameController(OutputView outputView, InputView inputView, RacingGameService racingGameService,
                          CarEngine carEngine) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.racingGameService = racingGameService;
        this.carEngine = carEngine;
    }

    public void run() {
        final RacingCars racingCars = readyToCarRace();
        processCarRace(racingCars);
        deliverToOutputViewAboutFinalWinnersResult(racingCars);
    }

    private RacingCars readyToCarRace() {
        List<String> carNames = GameUtil.splitByCommas(inputView.readCarNames());
        return new RacingCars(carNames, carEngine);
    }

    private void processCarRace(RacingCars cars) {
        int totalRound = inputView.readTotalRound();
        outputView.printPlayResultText();

        for (int round = 0; round < totalRound; round++) {
            OneGameResultsDto resultDto = racingGameService.playOneTimeCarRace(cars);
            deliverToOutputViewAboutOneGameResult(resultDto);
        }
    }

    private void deliverToOutputViewAboutOneGameResult(OneGameResultsDto resultDto) {
        outputView.printResult(resultDto);
    }

    private void deliverToOutputViewAboutFinalWinnersResult(RacingCars racingCars) {
        final List<String> winnerNames = racingGameService.calculateFinalWinners(racingCars);
        outputView.printFinalWinners(winnerNames);
    }
}
