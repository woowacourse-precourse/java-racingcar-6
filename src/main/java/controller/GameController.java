package controller;

import view.InputView;
import view.OutputView;
import validator.Validator;
import service.GameService;
import model.RaceCar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Validator validator = new Validator();
    private final GameService gameService = new GameService();

    private List<RaceCar> raceCars = new ArrayList<>();

    private int tryNumber;

    public void runName() {
        outputView.printName();

        List<String> names = Arrays.asList(inputView.input().split(","));
        validator.checkLengthName(names);

        gameService.createCarObject(names);
    }

    public void runTryNumber(){
        outputView.printTryNumber();

        tryNumber = validator.checkTryNumber(inputView.input());
    }

    public void runGame() {
        outputView.printRunGame();

        for(int runCount = 0; runCount < tryNumber; runCount++) {
            raceCars = gameService.MoveForward();
            gameResult();
        }

        outputView.printWinner();

    }

    public void gameResult() {
        for(RaceCar raceCar : raceCars) {
            outputView.printGameResult(raceCar.getName(), raceCar.getMoveForwardCount());
        }
    }
}
