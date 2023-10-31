package racingcar;

import racingcar.domain.Car;
import racingcar.domain.CarGenerator;
import racingcar.domain.Racing;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CarGenerator carGenerator = new CarGenerator();
        List<Car> racingCarList = carGenerator.createCars(carGenerator.askCarName());
        Racing racingOne = new Racing(racingCarList);
        racingOne.doOneGame();
    }
}
