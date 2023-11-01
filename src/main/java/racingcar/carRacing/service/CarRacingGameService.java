package racingcar.carRacing.service;

import static racingcar.carRacing.service.CarRacingResultService.printCurrentState;

import java.util.List;
import racingcar.car.model.Car;
import racingcar.car.service.CarMoveService;
import racingcar.carRacing.model.CarRacing;

public class CarRacingGameService {

    private final CarRacing carRacing;

    private final CarRacingInputService carRacingInputService = new CarRacingInputService();

    private final CarMoveService carMoveService = new CarMoveService();

    private Integer attemptCount;

    public CarRacingGameService(CarRacing carRacing) {
        this.carRacing = carRacing;
        this.attemptCount = 0;
    }

    public void waitInput() {
        List<String> carNames = carRacingInputService.inputCarNameList();
        carRacing.initCarList(carNames);
        attemptCount = carRacingInputService.inputAttemptCount();
    }

    public void doRace() {
        for (int i = 0; i < attemptCount; i++) {
            for (Car car : carRacing.getCarList()) {
                carMoveService.move(car);
            }
            printCurrentState(carRacing.getCarList());
        }
    }

}
