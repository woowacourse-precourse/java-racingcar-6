package racingcar.controller;

import racingcar.model.Car;
import racingcar.service.CarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class CarController {
    CarService service = new CarService();
    List<Car> cars;
    int tryCount = 0;
    public void start(){
        cars = service.namesToCarList(InputView.readCarNames());
        tryCount = service.checkTryCount(InputView.readTryCount());
        System.out.println();
        System.out.println("실행 결과");
        for(int i=0; i<tryCount; i++){
            carsAddDistance();
            OutputView.printCarsProgress(cars);
        }
        List<String> winners = service.getWinnerToList(cars);
        service.printWinner(winners);
    }

    public void carsAddDistance(){
        for(Car car : cars) {
            if (service.hasMovingForward()) {
                car.addDistance();
            }
        }
    }

}
