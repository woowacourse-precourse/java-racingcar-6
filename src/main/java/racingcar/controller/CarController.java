package racingcar.controller;

import racingcar.service.CarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarController {
    private InputView inputView;
    private OutputView outputView;
    private CarService carService;

    public CarController(InputView inputView, OutputView outputView, CarService carService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.carService = carService;
    }

    public static CarController getInstance() {
        return new CarController(InputView.getInstance(), OutputView.getInstance(), CarService.getInstance());
    }

    public void run() {
        String carNames = inputView.readCarNames();
        Integer tryNum = inputView.readTryNum();
        makeCars(carNames);
        racingStart(tryNum);
    }

    public void makeCars(String carNames) {
        carService.generateCarsInstance(carNames);
    }

    public void racingStart(Integer tryNum) {
        while(tryNum --> 0) {

        }
    }


}
