package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        List<String> carNames;
        List<Car> cars = new ArrayList<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carNames = List.of(Console.readLine().split(","));

        for (String carName : carNames) {
            if (carName.length() > 5)
                throw new IllegalArgumentException();
            cars.add(new Car(carName));
        }

        System.out.println("시도할 회수는 몇회인가요?");
        int forwardCount = Integer.parseInt(Console.readLine());
        System.out.println();

        System.out.println("실행 결과");

        while (forwardCount-- > 0) {
            for (Car car : cars) {
                car.tryMoving();
                System.out.println(car);
            }
            System.out.println();
        }

        int maxDistance = Collections.max(cars).getTotalForward();

        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getTotalForward() == maxDistance) {
                winners.add(car.getName());
            }
        }
        String result = String.join(",", winners);
        System.out.println("최종 우승자 : " + result);
    }
}
