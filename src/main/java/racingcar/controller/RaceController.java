package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.model.CarFactory;
import racingcar.model.CarList;
import racingcar.model.Race;
import racingcar.util.Convertor;
import racingcar.util.Constants;
import racingcar.util.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    private final CarFactory carFactory;
    private final CarList carList;
    private final Race race;

    public RaceController(CarFactory carFactory, CarList carList, Race race) {
        this.carFactory = carFactory;
        this.carList = carList;
        this.race = race;
    }

    private void startRace() {
        String input = InputView.inputString(Constants.INPUT_CAR_NAME);
        List<String> CarNameList = Convertor.splitCarNamesByComma(input);

        Validator.checkCarNameListSize(CarNameList);
        Validator.checkCarNameLength(CarNameList);
        Validator.checkCarNameEmpty(CarNameList);

        String inputMoveTryCount = InputView.inputString(Constants.INPUT_MOVE_TRY_COUNT);
        Validator.containsOnlyNumbers(inputMoveTryCount);

        carFactory.generateCar(CarNameList);
        for (int count = 0; count < Integer.parseInt(inputMoveTryCount); count++) {
            race.moveForward();
            OutputView.currentRacingView(carList);
        }
    }

    private void endRace() {
        OutputView.winnerView(race.checkWinner());
    }

    public void createRace() {
        startRace();
        endRace();
    }
}
