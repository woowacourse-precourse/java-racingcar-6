package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.User;
import racingcar.view.InputView;

import java.util.List;

public class RacingCarController {

    User user=new User();
    InputView inputView=new InputView();
    public void start(){
        List<Car> cars=user.nameForCar(inputView.inputCars());

    }
}
