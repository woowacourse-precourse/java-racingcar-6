package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        java.io.Console console = System.console();
        List<Car> cars = createCars(console);

        int numberOfAttempts = getNumberOfAttempts(console);

        race(cars, numberOfAttempts);

        assert cars != null;
        List<String> winners = getWinners(cars);

        printResult(cars);
        printWinners(winners);
    }

    private static int getNumberOfAttempts(java.io.Console console) {
        return 0;
    }

    private static List<Car> createCars(java.io.Console console) {
        return null;
    }

    private static List<Car> createCars(Console console) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)로 구분)");
        String input = console.readLine();
        String[] carNames = input.split(",");
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private static int getNumberOfAttempts(Console console) {
        System.out.println("시도할 회수는 몇 회인가요?");
        return Integer.parseInt(console.readLine());
    }

    private static void race(List<Car> cars, int numberOfAttempts) {
        for (int i = 0; i < numberOfAttempts; i++) {
            for (Car car : cars) {
                car.move(Randoms.pickNumberInRange(0, 9));
            }
        }
    }

    private static List<String> getWinners(List<Car> cars) {
        int maxPosition = 0;
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
                winners.clear();
                winners.add(car.getName());
            } else if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    private static void printResult(List<Car> cars) {
        System.out.println("실행 결과");
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getPositionString());
        }
    }

    private static void printWinners(List<String> winners) {
        String winnerText = String.join(", ", winners);
        System.out.println("최종 우승자 : " + winnerText);
    }
}
