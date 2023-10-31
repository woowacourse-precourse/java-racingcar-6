package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Manager;
import racingcar.service.RegisterService;
import racingcar.view.InputView;

public class RegisterController {

    private RegisterService registerService;

    public RegisterController() {
        this.registerService = new RegisterService();
    }

    public Manager registerCar(){
        String carNames = InputView.inputCarName();
        List<String> carList = registerService.convertCarNameToList(carNames);
        registerService.validateCarName(carList,carNames);

        String movementNumber = InputView.inputChanceNumber();
        registerService.validateInputMovementNumber(movementNumber);
        int moveCount = registerService.convertNumberToInt(movementNumber);

        Manager manager = new Manager(moveCount);

        for(String name : carList) {
            Car car = new Car(name, moveCount);
            manager.registerCar(car);
        }

        return manager;
    }
}
