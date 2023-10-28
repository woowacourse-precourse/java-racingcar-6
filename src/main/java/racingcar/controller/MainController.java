package racingcar.controller;

import Config.AppConfig;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import racingcar.input.InputHandler;
import racingcar.model.CarRepository;
import racingcar.model.car.Car;
import racingcar.service.CarSaveService;
import racingcar.view.View;

public class MainController {
    private static RaceController raceController = AppConfig.raceControllerImplements();
    public static void process() {
        View.gameStartMessage();
        String[] carNames = InputHandler.inputStringToArray();
        CarRepository carRepository = new CarRepository(new ArrayList<Car>());
        CarSaveService.SaveCars(carNames, carRepository);

        View.raceStartMessage();
        String roundInput = InputHandler.readInput();

        raceController.validateRoundInput(roundInput);
        raceController.processRace(roundInput, carRepository);

        Console.close();
    }
}
