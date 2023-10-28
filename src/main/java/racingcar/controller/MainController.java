package racingcar.controller;

import Config.AppConfig;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import racingcar.model.Car.Car;
import racingcar.model.Car.CarId;
import racingcar.model.CarRepository;
import racingcar.view.View;

public class MainController {
    private static RaceController raceController = AppConfig.raceControllerImplements();
    public static void process() {
        View.gameStartMessage();

        String NameInput = Console.readLine();
        String[] split = inputToArray(NameInput);

        CarRepository carRepository = insertCarToRepository(split, split.length);

        View.processStartMessage();
        String roundInput = Console.readLine();

        raceController.validateRoundInput(roundInput);
        raceController.processRace(roundInput, carRepository);

        Console.close();
    }

    private static String[] inputToArray(String NameInput) {
        String[] split = NameInput.split(AppConfig.INPUT_NAME_DELIMITER, AppConfig.INPUT_NAME_QUANTITY_LIMIT);
        CarId.validateRange(split.length);
        return split;
    }

    private static CarRepository insertCarToRepository(String[] split, int carQuantity) {
        CarRepository carRepository = new CarRepository(new ArrayList<Car>());
        for(int i = 0; i< carQuantity; i++) {
            Car participantCar = Car.of(i, split[i]);
            carRepository.save(participantCar);
        }
        return carRepository;
    }
}
