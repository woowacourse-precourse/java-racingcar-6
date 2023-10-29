package racingcar;

import racingcar.controller.CarController;
import racingcar.controller.RaceController;

public class Application {
    public static void main(String[] args) {
        CarController carController = new CarController();
        new RaceController(carController.getCarList());
        // TODO 2023 10 29 모든 함수에 대한 테스트 코드 작성을 목표로 한다.
    }
}
