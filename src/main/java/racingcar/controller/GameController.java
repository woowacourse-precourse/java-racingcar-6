package racingcar.controller;

import java.util.List;
import racingcar.dto.OneGameResultsDto;
import racingcar.service.RacingGameService;
import racingcar.service.domain.RacingCars;
import racingcar.service.domain.WootecoEngine;
import racingcar.utils.GameUtil;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final OutputView outputView;
    private final InputView inputView;
    private final RacingGameService racingGameService;

    public GameController(OutputView outputView, InputView inputView, RacingGameService racingGameService) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.racingGameService = racingGameService;
    }

    public void run() {
        final RacingCars racingCars = readyToCarRace();
        processCarRace(racingCars);
        deliverToOutputViewAboutFinalWinnersResult(racingCars);
    }

    private RacingCars readyToCarRace() {
        List<String> carNames = GameUtil.splitByCommas(inputView.readCarNames());
        return new RacingCars(carNames, new WootecoEngine());   // TODO: 컨트롤러에서 엔진을 설정하는게 마음에 안듦
    }

    private void processCarRace(RacingCars cars) {
        int attemptCounts = inputView.readAttemptCounts();
        outputView.printPlayResultText();
        for (int attempCount = 0; attempCount < attemptCounts; attempCount++) {
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
