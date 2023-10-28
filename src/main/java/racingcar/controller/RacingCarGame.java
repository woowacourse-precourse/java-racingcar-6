package racingcar.controller;

import racingcar.model.MovingCar;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    private MovingCar movingCar;

    public RacingCarGame() {
        movingCar = new MovingCar();
    }

    public List<String> splitCarNamesByComma() {
        String carName = InputView.getCarNameFromPlayer();
        String[] carNameArray = carName.split(",");

        List<String> carNameList = new ArrayList<>();
        for (int i = 0; i < carNameArray.length; i++) {
            carNameList.add(carNameArray[i]);
        }
        return carNameList;
    }

    public void moveCarForward() {
        for (String car: splitCarNamesByComma()){
            OutputView.printExecutionResult(car, );
        }
    }
}
