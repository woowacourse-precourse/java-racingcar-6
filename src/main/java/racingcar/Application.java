package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import racingcar.controller.CarController;
import racingcar.model.Car;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CarController carController = new CarController();
        /* 이름 입력 */
        System.out.println("경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)");
        ArrayList<Car> cars = carController.createCars(Console.readLine());
    }
}
