package racingcar.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.common.StringToListConverter;
import racingcar.common.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    StringToListConverter converter = new StringToListConverter();

    public void raceStart() {
        outputView.printInputCarNames();
        String carNames = inputView.carNames();
        List<String> carNameList = converter.convert(carNames);
        Validator.validateCarNames(carNameList);

        outputView.printInputRoundNumber();
        String roundNumber = inputView.roundNumber();
        System.out.println(roundNumber);
    }


}
