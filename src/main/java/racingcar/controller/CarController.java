package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.CarModel;
import racingcar.view.OutputView;

public class CarController {

    private List<CarModel> carModelList = new ArrayList<>();

    public CarController(List<String> carList) {
        for (String s : carList) {
            this.carModelList.add(new CarModel(s));
        }
    }

    public void carForward() {
        for ( CarModel carModel : carModelList) {
            if (forwardCheck()) {
                carModel.increaseLocation();
            }
            OutputView.printRacing(carModel.carLocationState());
        }
        System.out.println("");
    }

    public boolean forwardCheck() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
