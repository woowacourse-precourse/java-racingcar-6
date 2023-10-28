package racingcar.Controller;

import Config.AppConfig;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import racingcar.Model.Car.Car;
import racingcar.Model.Car.CarId;
import racingcar.Model.CarRepository;
import racingcar.View.View;

public class MainController {
    private static RaceController raceController = AppConfig.raceControllerImplements();
    public static void process() {
        View.gameStartMessage();

        String NameInput = Console.readLine();
        String[] split = NameInput.split(AppConfig.INPUT_NAME_DELIMITER, AppConfig.INPUT_NAME_QUANTITY_LIMIT);
        int carQuantity = split.length;
        CarId.validateRange(carQuantity);

        CarRepository carRepository = saveRepository(split, carQuantity);

        View.processStartMessage();
        String roundInput = Console.readLine();

        raceController.validateRoundInput(roundInput);
        raceController.processRace(roundInput, carRepository);

        Console.close();
    }

    private static CarRepository saveRepository(String[] split, int carQuantity) {
        CarRepository carRepository = new CarRepository(new ArrayList<Car>());
        for(int i = 0; i< carQuantity; i++) {
            Car participantCar = Car.of(i, split[i]);
            carRepository.save(participantCar);
        }
        return carRepository;
    }
}
