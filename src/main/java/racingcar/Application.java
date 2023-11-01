package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<Car> cars = setCars();

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

        printWinners(cars);
    }


    private static List<Car> setCars() {
        List<String> carNames = List.of(Console.readLine().split(","));

        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            if (carName.length() > 5)
                throw new IllegalArgumentException();
            cars.add(new Car(carName));
        }
        return cars;
    }

    private static void printWinners(List<Car> carList) {
        List<String> winners = getWinners(carList);
        String result = String.join(",", winners);
        System.out.println("최종 우승자 : " + result);
    }

    private static List<String> getWinners(List<Car> carList) {
        int maxDistance = Collections.max(carList).getTotalForward();

        List<String> winners = new ArrayList<>();
        for (Car car : carList) {
            if (car.getTotalForward() == maxDistance) {
                winners.add(car.getName());
            }
        }
        return winners;
    }


}
