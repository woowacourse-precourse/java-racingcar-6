package racingcar.Controller;

import racingcar.domain.Car;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputController {
    Car car = new Car();
    List<String> carNames;
    public void getNameOfCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        splitName(readLine());
    }

    private void splitName(String readLine) {
        carNames= List.of(readLine.split(","));
        carNames.forEach(carName -> car.setName(carName));
    }

    public int getRaceTries() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(readLine());
    }
}