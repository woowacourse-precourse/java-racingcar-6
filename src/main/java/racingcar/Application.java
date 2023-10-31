package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] name = Console.readLine().split(",");

        List<Car> cars = new ArrayList<>();
        for (String carName : name) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException();
            }
            cars.add(new Car(carName));
        }

        System.out.println("시도할 회수는 몇회인가요?");
        int number = Integer.parseInt(Console.readLine());
        if (number < 0) {
            throw new IllegalArgumentException();
        }
        System.out.println();

        System.out.println("실행 결과");
        for (int i = 0; i<number; i++){
            for (Car car : cars) {
                car.move();
                System.out.println(car.getName() + " : " + car.getProgress());
            }
            System.out.println();
        }

        int maxDistance = 0;
        for (Car car : cars) {
            maxDistance = Math.max(maxDistance, car.getDistance());
        }

        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getDistance() == maxDistance) {
                winners.add(car.getName());
            }
        }

        System.out.println("최종 우승자 : " + String.join(", ",winners));

    }
}
