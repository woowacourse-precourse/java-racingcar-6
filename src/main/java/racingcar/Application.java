package racingcar;

import racingcar.object.Car;
import racingcar.object.TryCount;
import racingcar.service.CarService;
import racingcar.service.TryCountService;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // try-catch로 예외처리를 할 경우, 주어진 테스트코드가 실패함.
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