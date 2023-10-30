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
        return reStartOrExit();
    }

    private void runName() {
        outputView.printName();

        List<String> names = Arrays.asList(inputView.input().split(",", -1));
        validator.checkLengthName(names);

        gameService.createCarObject(names);
    }

    private void runTryNumber(){
        outputView.printTryNumber();

        tryNumber = validator.checkTryNumber(inputView.input());
    }

    private void runGame() {
        outputView.printRunGame();

        for(int runCount = 0; runCount < tryNumber; runCount++) {
            raceCars = gameService.MoveForward();
            gameResult();
        }
    }

    private void gameResult() {
        for(RaceCar raceCar : raceCars) {
            outputView.printGameResult(raceCar.getName(), raceCar.getMoveForwardCount());
        }
        outputView.printChangeLine();
    }

    private void runWinner() {
        outputView.printWinner(gameService.gameWinner());
    }

    private boolean reStartOrExit() {
        outputView.printRestartOrExit();

        String progress =  validator.checkStatus(inputView.input());

        if(Objects.equals(ProgressType.RESTART.getValue(), progress)) {
            return true;
        };
        return false;
    }
}
