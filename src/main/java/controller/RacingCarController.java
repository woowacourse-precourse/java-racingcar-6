package controller;

import domain.Car;
import service.CarService;
import service.RacingCarService;
import view.InputView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarController {

    public static InputView inputView = new InputView();
    public static CarService carService = new CarService();
    public static List<Car> cars = new ArrayList<>();
    public static RacingCarService racingCarService = new RacingCarService();
    public void start() {
        String carName = inputView.inputCarName();
        cars = carService.initRacingCars(carService.stringToList(carName));
        int tryTime = inputView.inputTryTime();
        run(tryTime);
    }
    public void run(int tryTime) {
        do{
            racingCarService.generateRandomNumber();
        }
    }
}
