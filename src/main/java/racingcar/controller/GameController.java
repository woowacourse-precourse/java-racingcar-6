package racingcar.controller;

import racingcar.IOConsole;
import racingcar.model.Car;
import racingcar.service.GameService;

import java.util.List;

public class GameController {
    private GameService gameService;

    public void play(){
        List<Car> cars = IOConsole.readCarNames().stream().map(Car::new).toList();
        int trial = IOConsole.readTrial();

        gameService = new GameService(cars, trial);

        gameService.playRace();
        end();
    }
    private void end(){
        List<String> winners = gameService.getWinners();
        IOConsole.printWinner(winners);
    }

}
