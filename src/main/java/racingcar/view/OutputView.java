package racingcar.view;

import racingcar.model.Car;
import racingcar.model.CarRepository;

import java.util.List;

public class OutputView {
    public void printOneRoundResult(CarRepository carRepository) {
        for (Car car : carRepository.getCars()) {
            System.out.printf("%s : %s \n", car.getName(), "-".repeat(car.getForwardCount()));
        }
        System.out.println();
    }

    public void getResult(List<String> maxCars) {
        System.out.printf("최종 우승자 : %s", maxCars.get(0));
        for (int i = 1; i < maxCars.size(); i++) {
            System.out.print(", " + maxCars.get(i));
        }
        System.out.println();
    }
}
