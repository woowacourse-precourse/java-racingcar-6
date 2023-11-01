package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = scanner.nextLine();
        List<String> carNames = Arrays.asList(carNamesInput.split(","));

        System.out.println("시도할 횟수는 몇회인가요?");
        int raceTimes = scanner.nextInt();

        List<Car> cars = createCars(carNames);
        Race race = new Race(cars);

        System.out.println("실행 결과");
        for (int i = 0; i < raceTimes; i++) {
            race.run();
            System.out.println(printRaceResult(cars));
            System.out.println();
        }

        System.out.println(printWinners(cars));
    }

    static List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name.trim()));
        }
        return cars;
    }

    static String printRaceResult(List<Car> cars) {
        StringBuilder result = new StringBuilder();
        for (Car car : cars) {
            result.append(getCarResult(car));
        }
        return result.toString();
    }

    static String getCarResult(Car car) {
        return car.getName() + " : " + "-".repeat(car.getPosition()) + "\n";
    }

    static String printWinners(List<Car> cars) {
        int maxPosition = 0;
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        return "최종 우승자 : " + String.join(", ", winners);
    }
}

