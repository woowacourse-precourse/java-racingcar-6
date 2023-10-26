package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import racingcar.controller.CarController;
import racingcar.model.Car;

public class Application {
    public static void main(String[] args) {
        CarController carController = new CarController();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<Car> cars = carController.makeCar(readLine());
    }
}
