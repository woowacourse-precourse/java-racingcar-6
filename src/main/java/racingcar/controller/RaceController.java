package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarFactory;
import racingcar.model.Race;
import racingcar.util.Convertor;
import racingcar.util.Constants;
import racingcar.util.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    private final CarFactory carFactory;

    public RaceController(CarFactory carFactory) {
        this.carFactory = carFactory;
    }

    public void playRacing() {
        String CarNameString = InputView.inputString(Constants.INPUT_CAR_NAME);
        List<String> CarNameList = Convertor.splitCarNamesByComma(CarNameString);
        Validator.checkCarNameListSize(CarNameList);
        Validator.checkCarNameLength(CarNameList);
        Validator.checkCarNameEmpty(CarNameList);

        String inputMoveTryCount = InputView.inputString(Constants.INPUT_MOVE_TRY_COUNT);
        Validator.containsOnlyNumbers(inputMoveTryCount);

        List<Car> cars = carFactory.generateCars(CarNameList);
    }
}
