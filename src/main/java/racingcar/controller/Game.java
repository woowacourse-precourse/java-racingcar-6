package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class Game {
    public void start() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputNames = Console.readLine();
        String[] names = inputNames.split(",");
        for (String name : names) {
            if (name.isBlank() || name.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            }
            System.out.println(name);
        }

        System.out.println("시도할 회수는 몇회인가요?");
        String inputAttemptCount = Console.readLine();
        int attemptCount;
        try {
            attemptCount = Integer.parseInt(inputAttemptCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 숫자 형식이 아닙니다.");
        }
        if (attemptCount <= 0) {
            throw new IllegalArgumentException("시도할 횟수는 0회 이상만 가능합니다.");
        }
        System.out.println(attemptCount);

        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            Car car = new Car(name);
            cars.add(car);
        }
        for (int attempt = 0; attempt < attemptCount; attempt++) {
            for (Car car : cars) {
                if (Randoms.pickNumberInRange(0, 9) >= 4) {
                    car.moveForward();
                }
                System.out.println(car);
            }
        }
    }
}
