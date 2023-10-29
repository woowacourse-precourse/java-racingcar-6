package racingcar.controller;

import racingcar.OutputConsole;
import racingcar.model.Car;
import racingcar.service.GameService;

import java.util.List;

public class GameController {
    static private GameService gameService;

    public void play(){
        List<Car> cars = OutputConsole.readCarNames().stream().map(Car::new).toList();
        int trial = OutputConsole.readTrial();

        gameService = new GameService(cars, trial);

        gameService.playRace();
        end();
    }
    private static void end(){
        List<String> winners = gameService.getWinners();
        OutputConsole.printWinner(winners);
    }

}
