package racingcar.controller;

import java.util.List;
import racingcar.model.CarFactory;
import racingcar.model.CarList;
import racingcar.model.Race;
import racingcar.util.Convertor;
import racingcar.util.Constants;
import racingcar.util.Validator;
import racingcar.view.InputView;

public class RaceController {
    private final CarFactory carFactory;
    private final CarList carList;
    private final Race race;

    public RaceController(CarFactory carFactory,CarList carList,Race race) {
        this.carFactory = carFactory;
        this.carList = carList;
        this.race = race;
    }

    public void startRace() {
        String CarNameString = InputView.inputString(Constants.INPUT_CAR_NAME);
        List<String> CarNameList = Convertor.splitCarNamesByComma(CarNameString);
        Validator.checkCarNameListSize(CarNameList);
        Validator.checkCarNameLength(CarNameList);
        Validator.checkCarNameEmpty(CarNameList);

        String inputMoveTryCount = InputView.inputString(Constants.INPUT_MOVE_TRY_COUNT);
        Validator.containsOnlyNumbers(inputMoveTryCount);

        carFactory.generateCar(CarNameList);
        for (int count = 0; count < Integer.parseInt(inputMoveTryCount); count++) {
            race.moveForward();
        }
    }
}
