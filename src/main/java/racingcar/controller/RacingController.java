package racingcar.controller;

import java.util.List;
import racingcar.controller.validator.UserInputValidator;
import racingcar.model.GameService;
import racingcar.model.dto.RoundResult;
import racingcar.model.dto.Winners;
import racingcar.model.gameinfo.CarInfo;
import racingcar.model.gameinfo.RoundInfo;
import racingcar.view.input.InputView;
import racingcar.view.output.OutputView;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;
    private final GameService gameService;
    private final UserInputValidator userInputValidator;
    private RoundInfo roundInfo;
    private List<CarInfo> carInfos;

    public RacingController(InputView inputView, OutputView outputView, GameService gameService,
                            UserInputValidator userInputValidator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameService = gameService;
        this.userInputValidator = userInputValidator;
    }

    public void playGame() {
        initializeGame();
        outputView.printSeparator();

        while (!gameService.isGameOver(roundInfo)) {
            RoundResult roundResult = gameService.executeRound(roundInfo, carInfos);
            outputView.printRoundResult(roundResult);
        }

        Winners winners = gameService.findWinners(carInfos);
        outputView.printWinner(winners);
    }

    private void initializeGame() {
        List<String> carNames = getCarNames();
        Integer roundCount = getRoundCount();

        this.carInfos = carNames.stream()
                .map(CarInfo::new)
                .toList();

        this.roundInfo = new RoundInfo(roundCount);
    }

    private Integer getRoundCount() {
        return userInputValidator.validateRoundCount(inputView.getRoundCount());
    }

    private List<String> getCarNames() {
        return userInputValidator.validateCarNames(inputView.getCarNames());
    }
}
