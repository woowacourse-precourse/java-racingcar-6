package racingcar;

import racingcar.object.Car;
import racingcar.object.TryCount;
import racingcar.service.CarService;
import racingcar.service.TryCountService;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CarService carService = new CarService();
        TryCountService tryCountService = new TryCountService();

        carService.printGuide_InputCarsName();
        List<Car> carList = carService.inputCarsName();
        tryCountService.printGuide_InputTryCount();
        TryCount tryCount = tryCountService.inputTryCount();

        for(int i = 0; i < tryCount.getCount(); i++) {
            carService.moveCars(carList);
            carService.printCarStatus(carList);
        }
        carService.printWinners(carList);
    }
}