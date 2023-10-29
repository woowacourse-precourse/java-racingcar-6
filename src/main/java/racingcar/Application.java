package racingcar;

import racingcar.domain.Attempt;
import racingcar.domain.Car;
import racingcar.domain.MovingCondition;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Car car = new Car();
        List<String> carNames = car.getNames();
        System.out.println("자동차 이름: " + carNames);

        Attempt attempt = new Attempt();
        int attemptNum = attempt.attemptNum();
        System.out.println("시도 회수: " + attemptNum);

        MovingCondition movingCondition = new MovingCondition();
        boolean condition = movingCondition.isMoveForward();
        System.out.println("전진: " + condition);
    }
}
