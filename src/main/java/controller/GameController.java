package controller;

import view.InputView;
import view.OutputView;
import validator.Validator;
import service.GameService;
import model.RaceCar;
import status.ProgressType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class GameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Validator validator = new Validator();
    private final GameService gameService = new GameService();
    private List<RaceCar> raceCars = new ArrayList<>();
    private int tryNumber;

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

        gameService.createRaceCarObject(names);
    }

    private void runTryNumber(){
        outputView.printTryNumberMessage();

        tryNumber = validator.checkRegExpTryNumber(inputView.input());
    }

    private void runGame() {
        outputView.printRunResultMessage();

        for(int runCount = 0; runCount < tryNumber; runCount++) {
            raceCars = gameService.MoveForward();
            runResult();
        }
    }

    private void runResult() {
        for(RaceCar raceCar : raceCars) {
            outputView.printRunResult(raceCar.getName(), raceCar.getMoveForwardCount());
        }
        outputView.printChangeLine();
    }

    private void runWinner() {
        outputView.printWinner(gameService.gameWinner());
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
