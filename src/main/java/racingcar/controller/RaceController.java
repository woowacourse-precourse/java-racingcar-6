package racingcar.controller;

import java.util.List;
import racingcar.model.CarFactory;
import racingcar.util.Convertor;
import racingcar.util.Constants;
import racingcar.util.Validator;
import racingcar.view.InputView;

public class RaceController {
    private final CarFactory carFactory;

    public RaceController() {
        this.carFactory = new CarFactory();
    }

    public void playRacing() {
        String CarNameString = InputView.inputString(Constants.INPUT_CAR_NAME);
        List<String> CarNameList = Convertor.splitCarNamesByComma(CarNameString);
        Validator.checkCarNameListSize(CarNameList);
        Validator.checkCarNameLength(CarNameList);
        Validator.checkCarNameEmpty(CarNameList);

        String inputMoveTryCount = InputView.inputString(Constants.INPUT_MOVE_TRY_COUNT);
        Validator.containsOnlyNumbers(inputMoveTryCount);

    }
}
