package racingcar;

import racingcar.carRepository.CarRepository;
import racingcar.carRepository.CarRepositoryInterface;
import racingcar.model.Car;
import racingcar.service.CarService;
import racingcar.view.View;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        CarRepositoryInterface carRepository = new CarRepository();
        CarService carService = new CarService(carRepository);
        View view = new View(carService);
        view.inputCarName();
        view.moveCar();
        view.finalResult();

    }
}
