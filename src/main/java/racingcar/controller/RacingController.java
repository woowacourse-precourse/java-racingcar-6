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
import racingcar.view.OutputView;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Util util;
    private List<Car> carList;
    private int acceptNumber;
    public RacingController() {
        inputView = new InputView();
        outputView = new OutputView();
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

    public void acceptNumberSet(){
        String acceptNumberString = inputView.printInputAttemptNumber();
        isStringBlank(acceptNumberString);
        int num = isNonNumericString(acceptNumberString);
        isNegativeNumber(num);
        acceptNumber = num;
    }

    public void play(){
        outputView.printPlayResult();
        for (int i=0; i<acceptNumber;i++){
            carList.forEach(car -> car.move());
            outputView.printCarListResult(carList);
        }

    }

    public void end()
    {
        outputView.printWinner(util.getWinner(carList));
    }
    public void startGame() {
        carSet();
        acceptNumberSet();
        play();
        end();

    }
}
