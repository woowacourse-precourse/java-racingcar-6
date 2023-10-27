package racingcar.Controller;

import Config.AppConfig;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import racingcar.Model.Car.Car;
import racingcar.Model.Car.CarId;
import racingcar.Model.CarRepository;

public class MainController {
    private static RaceController raceController = AppConfig.raceControllerImplements();

    public static void process() {
        String NameInput = Console.readLine();
        String[] split = NameInput.split(AppConfig.INPUT_DELIMITER, Integer.MAX_VALUE);
        int carQuantity = split.length;
        CarId.validateRange(carQuantity);

        CarRepository carRepository = new CarRepository(new ArrayList<>());
        for(int i=1; i<=carQuantity; i++) {
            Car participantCar = Car.of(i, split[i - 1]);
            carRepository.save(participantCar);
        }

        String roundInput = Console.readLine();
        raceController.validateRoundInput(roundInput);
        raceController.processRace(roundInput, carRepository);
    }


}
