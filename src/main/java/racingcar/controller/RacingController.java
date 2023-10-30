package racingcar.controller;

import java.util.List;
import racingcar.domain.CarList.CarDto;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final RacingService racingService = new RacingService();


    public void initRacingGame() {
        outputView.printRequestCarName();
        List<String> userInput = inputView.getUserInputCarNames();
        outputView.printRequestRound();
        int racingRound = inputView.getUserInputRacingRound();
        racingService.setCars(userInput);
        outputView.printResult();
        playRacingGame(racingRound);
    }

    private void playRacingGame(int racingRound) {
        for (int i = 0; i < racingRound; i++) {
            List<CarDto> carDtos = racingService.startRacing();
            outputView.printRoundResult(carDtos);
        }
    }

    public void replayRacingGame() {
        initRacingGame();
    }


}
