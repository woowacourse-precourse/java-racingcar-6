package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import config.RaceConfig;
import java.util.ArrayList;
import racingcar.input.InputHandler;
import racingcar.model.CarRepository;
import racingcar.model.car.Car;
import racingcar.service.CarSaveService;
import racingcar.view.View;

public class MainController {
    private static RaceController raceController = RaceConfig.raceControllerImplements();
    private CarRepository carRepository = new CarRepository(new ArrayList<Car>());
    public void process() {
        startGame();
        startRace();
        closeGame();
    }
    private void startGame() {
        View.gameStartMessage();
        String[] carNames = InputHandler.inputStringToArray();
        CarSaveService.SaveCars(carNames, carRepository);
    }

    private void startRace() {
        View.raceStartMessage();
        String roundInput = InputHandler.readInput();
        raceController.validateRoundInput(roundInput);
        raceController.processRace(roundInput, carRepository);
    }

    private static void closeGame() {
        Console.close();
    }


}
