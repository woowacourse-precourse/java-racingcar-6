package racingcar.controller;

import static racingcar.util.validator.InputValidator.IsListDuplicate;
import static racingcar.util.validator.InputValidator.checkComma;
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


    public void setting(){
        String cars = inputView.printInputCarName();
        isStringBlank(cars);
        checkComma(cars);

        List<String> list = util.splitStringToList(cars);
        IsListDuplicate(list);
        list.forEach(car -> carList.add(new Car(car)));

    }
    public void startGame() {
        setting();

    }
}
