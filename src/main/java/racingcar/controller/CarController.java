package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.CarModel;

public class CarController {

    private List<CarModel> carModelList = new ArrayList<>();

    public CarController(List<String> carList) {
        for (String s : carList) {
            this.carModelList.add(new CarModel(s));
        }
    }

}
