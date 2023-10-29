package controller;

import domain.Car;
import service.CarService;
import service.RacingCarService;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarController {

    public static InputView inputView = new InputView();
    public static CarService carService = new CarService();
    public static List<Car> cars = new ArrayList<>();
    public static RacingCarService racingCarService = new RacingCarService();
    public static OutputView outputView = new OutputView();
    public void start() {
        String carName = inputView.inputCarName();
        cars = carService.initRacingCars(carService.stringToList(carName));
        int tryTime = inputView.inputTryTime();
        run(tryTime);
    }
    public void run(int tryTime) {
        int tryCount = 0;
        while(tryCount<tryTime){
            List<Integer> allRandomNumber = racingCarService.saveRandomNumber(cars);
            for(int i=0; i<cars.size(); i++) {
                racingCarService.move(cars.get(i),allRandomNumber.get(i));
                outputView.printEachResult(cars.get(i),allRandomNumber.get(i));
            }
            System.out.println();
            tryCount++;
        }

    }
}
