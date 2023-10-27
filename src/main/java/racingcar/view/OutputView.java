package racingcar.view;

import racingcar.model.Car;
import racingcar.model.CarRepository;

public class OutputView {
    public void printOneRoundResult(CarRepository carRepository) {
        for (Car car : carRepository.getCars()) {
            System.out.printf("%s : %s \n", car.getName(), "-".repeat(car.getForwardCount()));
        }
        System.out.println();
    }
}
