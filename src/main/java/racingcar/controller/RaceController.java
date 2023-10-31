package racingcar.controller;


import java.util.List;
import racingcar.domain.Car;
import racingcar.enums.InputMessage;
import racingcar.service.CarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    private final OutputView outputView;
    private final InputView inputView;
    private final CarService carService;

    public RaceController() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
        this.carService = new CarService();
    }

    public void startGame() {
        List<Car> cars = getCars();
    }

    private List<Car> getCars() {
        outputView.printMessage(InputMessage.INPUT_CAR_NAME_MESSAGE.getValue());
        String input = inputView.readNames();
        return carService.createCars(input);
    }
}
