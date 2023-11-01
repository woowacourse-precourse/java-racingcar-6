package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.RacingCars;
import racingcar.view.InputView;

public class CarRegisterController {
    private final RacingCars racingCars;
    
    public CarRegisterController(RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    public void registerCars() {
        List<String> names = InputHandler.parseCarName(InputView.askForCarName());
        for(String name : names) {
            enterRacing(name);
        }
    }

    private void enterRacing(String name) {
        racingCars.addCar(new Car(name));
    }

}
