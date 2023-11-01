package racingcar.controller;

import racingcar.service.CarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarController {
    private InputView inputView;
    private OutputView outputView;
    private CarService carService;
    private static CarController instance;

    public CarController(InputView inputView, OutputView outputView, CarService carService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.carService = carService;
    }

    public static CarController getInstance() {
        if(instance == null) {
            instance = new CarController(InputView.getInstance(), OutputView.getInstance(), CarService.getInstance());
        }
        return instance;
    }

    public void run() {
        String carNames = inputView.readCarNames();
        Integer tryNum = inputView.readTryNum();
        makeCars(carNames);
        racing(tryNum);
    }

    private void makeCars(String carNames) {
        carService.generateCarsInstance(carNames);
    }

    private void racing(Integer tryNum) {
        outputView.printRacingResult();
        while(tryNum --> 0) {
            carService.tryRacing();
            outputView.printCarRacingStatus(carService.getRacingResult());
        }
        endRacing();
    }

    private void endRacing() {
        outputView.printWinner(carService.getWinner());
    }

}
