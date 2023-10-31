package racingcar.controller;

import static racingcar.util.validator.InputValidator.isListDuplicate;

import static racingcar.util.validator.InputValidator.checkComma;
import static racingcar.util.validator.InputValidator.isNegativeNumber;
import static racingcar.util.validator.InputValidator.isNonNumericString;
import static racingcar.util.validator.InputValidator.isStringBlank;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.util.Util;
import racingcar.view.InputView;

public class RacingController {
    private final InputView inputView;
    private final Util util;
    private List<Car> carList;
    public RacingController() {
        inputView = new InputView();
        util = new Util();
        carList = new ArrayList<>();
    }

    public void carSet()
    {
        String cars = inputView.printInputCarName();
        isStringBlank(cars);
        checkComma(cars);
        List<String> list = util.splitStringToList(cars);
        isListDuplicate(list);
        list.forEach(car -> carList.add(new Car(car)));
    }

    public int acceptNumberSet(){
        String acceptNumberString = inputView.printInputAttemptNumber();
        isStringBlank(acceptNumberString);
        int acceptNumber = isNonNumericString(acceptNumberString);
        isNegativeNumber(acceptNumber);
        return acceptNumber;
    }

    public void startGame() {
        carSet();
        acceptNumberSet();

    }
}
