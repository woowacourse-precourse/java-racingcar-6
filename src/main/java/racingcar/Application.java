package racingcar;

import racingcar.domain.Attempt;
import racingcar.domain.Car;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Car car = new Car();
        List<String> carNames = car.getNames();
        System.out.println("자동차 이름: " + carNames);

        Attempt attemptNum = new Attempt();
        System.out.println("시도 회수: " + attemptNum);
    }
}
