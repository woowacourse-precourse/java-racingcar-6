package racingcar.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.model.CarModel;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private List<CarModel> carModelList = new ArrayList<>();
    private int repeatNumber;

    public void inputCarNames() {
        OutputView.printCarNameDemand();
        List<String> carList = Arrays.asList(InputView.inputCarName().split(","));

        for (String s : carList) {
            this.carModelList.add(new CarModel(s));
        }
    }

    public void inputRepeatNumber() {
        OutputView.printRepeatNumberDemand();
        this.repeatNumber = Integer.parseInt(InputView.inputRepeatNumber());
    }

}
