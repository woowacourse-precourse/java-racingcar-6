package racingcar.controller;

import java.util.ArrayList;
import racingcar.dto.CarsGenerateDto;
import racingcar.service.GameService;
import racingcar.service.Referee;
import racingcar.view.OutputView;

public class GameController {

    private final InputController inputController;

    private final GameService gameService;

    private final Referee referee;

    private final OutputView outputView;

    public GameController() {
        inputController = new InputController();
        gameService = new GameService();
        referee = new Referee();
        outputView = new OutputView();
    }

    public void play() {
        String[] carNames = inputController.inputCarNames();
        int trialNumber = inputController.inputTrialNumber();

        CarsGenerateDto carsGenerateDto = new CarsGenerateDto(new ArrayList<>(), carNames);
        outputView.showResultMessage();

        gameService.playUntilTrialNumber(trialNumber, carsGenerateDto);
        outputView.showWinner(referee, carsGenerateDto);
    }
}
