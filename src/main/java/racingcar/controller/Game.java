package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.service.GameService;
import racingcar.view.ConsoleInput;
import racingcar.view.ConsoleOutput;

public class Game {

    private List<Car> users;

    private int attemptsNumber;

    private GameService gameService;

    public void start() {
        init();
        progress();
        end();
    }

    private void init() {
        users = ConsoleInput.carNamesInput();
        attemptsNumber = ConsoleInput.attemptsNumberInput();
        gameService = new GameService(users);
    }

    private void progress() {
        ConsoleOutput.alertExecutionResultPrint();
        runRacing(gameService);
    }

    private void end() {
        List<Car> winnerList = gameService.selectWinner();
        ConsoleOutput.winnersPrint(winnerList);
    }

    private void runRacing(GameService gameService) {
        for (int i = 0; i < attemptsNumber; i++) {
            gameService.race();
            ConsoleOutput.executionResultPrint(users);
        }
    }
}
