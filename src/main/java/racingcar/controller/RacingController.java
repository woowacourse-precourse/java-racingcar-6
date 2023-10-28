package racingcar.controller;

import static racingcar.view.InputView.inputCarName;
import static racingcar.view.OutputView.printCarNameDemand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.model.CarModel;

public class RacingController {
    private List<CarModel> carModelList = new ArrayList<>();

    public void inputCarNames() {
        printCarNameDemand();
        List<String> carList = Arrays.asList(inputCarName().split(","));

        for (String s : carList) {
            this.carModelList.add(new CarModel(s));
        }
    }
}
