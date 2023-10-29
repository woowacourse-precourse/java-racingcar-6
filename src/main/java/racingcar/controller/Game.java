package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.utils.InputValidator;
import racingcar.utils.StringConvertor;
import racingcar.view.InputView;

public class Game {

    public List<String> getCarNames() {
        InputView.inputCarNames();
        String carInput = Console.readLine();
        List<String> carNames = StringConvertor.convertStringToList(carInput);
        InputValidator.checkCarNames(carNames, carInput);
        return carNames;
    }

    public int getTryNumber() {
        InputView.inputTryNumber();
        String tryNumber = Console.readLine();
        InputValidator.checkTryNumberIsInteger(tryNumber);
        return StringConvertor.convertStringToInt(tryNumber);
    }

}
