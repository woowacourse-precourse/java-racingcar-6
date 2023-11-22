package racingcar.service;

import static racingcar.constant.Constant.ZERO;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.DriveStrategy;
import racingcar.model.RandomDriveStrategy;
import racingcar.view.input.InputView;
import racingcar.view.output.OutputView;

public class CreateCharacterService {

    private final InputView inputView;
    private final OutputView outputView;

    public CreateCharacterService(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public List<Car> createCharacter() {
        outputView.printOutCarName();
        List<String> carNames = inputView.inputCarName();
        List<Car> cars = new ArrayList<>();
        DriveStrategy driveStrategy = new RandomDriveStrategy();
        for (String carName : carNames) {
            Car car = new Car(driveStrategy, carName, ZERO.number);
            cars.add(car);
        }

        return cars;
    }
}
