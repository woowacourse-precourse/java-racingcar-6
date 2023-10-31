package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.validator.Validator;
import racingcar.service.GameService;
import racingcar.model.RaceCar;
import racingcar.status.ProgressType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final GameService gameService;
    private final Validator validator;
    private List<RaceCar> raceCars = new ArrayList<>();
    private int tryNumber;

    public GameController(InputView inputView, OutputView outputView,GameService gameService, Validator validator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameService = gameService;
        this.validator = validator;
    }

    public boolean Progress() {
        runName();
        runTryNumber();
        runGame();
        runWinner();
        return restartOrExit();
    }

    private void runName() {
        outputView.printNameMessage();

        List<String> names = Arrays.asList(inputView.input().split(",", -1));
        validator.checkLengthName(names);

        raceCars = gameService.createRaceCarObject(raceCars, names);
    }

    private void runTryNumber() {
        outputView.printTryNumberMessage();

        tryNumber = validator.checkRegExpTryNumber(inputView.input());
    }

    private void runGame() {
        outputView.printRunResultMessage();

        do {
            for(RaceCar raceCar : raceCars) {
                gameService.MoveForward(raceCar, gameService.randomNumPick());
                runResult(raceCar);
            }
            tryNumber--;

            outputView.printChangeLine();
        } while(tryNumber > 0);
    }

    private void runResult(RaceCar raceCar) {
        outputView.printRunResult(raceCar.getName(), raceCar.getMoveForwardCount());
    }

    private void runWinner() {
        outputView.printWinner(gameService.gameWinner(raceCars));
    }

    private boolean restartOrExit() {
        outputView.printRestartOrExitMessage();

        String progress =  validator.checkRegExpProcess(inputView.input());

        if(Objects.equals(ProgressType.RESTART.getValue(), progress)) {
            return true;
        };
        return false;
    }
}
