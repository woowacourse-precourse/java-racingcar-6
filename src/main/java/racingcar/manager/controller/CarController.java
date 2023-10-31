package racingcar.manager.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import racingcar.manager.model.Car;
import racingcar.manager.view.CarView;

public class CarController {
    private static int START_NUMBER_RANGE = 0;
    private static int END_NUMBER_RANGE = 9;
    private static int MOVE_CONDITION = 4;

    private CarView carView = new CarView();
    public List<Car> getCars(){
        List<String> carNames = carView.inputCarNames();
        List<Car> cars = Car.getCarList(carNames);

        return cars;
    }



}
