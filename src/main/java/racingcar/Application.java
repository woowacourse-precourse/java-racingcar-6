package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Console console = new Console();
        String[] carNames = getInputCarNames(console);
        int tryCount = getInputTryCount(console);

        List<Car> cars = createCars(carNames);

        System.out.println("실행 결과");

        for (int i = 0; i < tryCount; i++) {
            playRound(cars);
            printRoundResult(cars);
        }

        List<String> winners = getWinners(cars);
        printWinners(winners);
    }

    private static String[] getInputCarNames(Console console) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return console.readLine().split(",");
    }

    private static int getInputTryCount(Console console) {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(console.readLine());
    }

    private static List<Car> createCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private static void playRound(List<Car> cars) {
        for (Car car : cars) {
            car.move();
        }
    }

    private static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            StringBuilder result = new StringBuilder(car.getName() + " : ");
            for (int i = 0; i < car.getPosition(); i++) {
                result.append("-");
            }
            System.out.println(result.toString());
        }
        System.out.println();
    }

    private static List<String> getWinners(List<Car> cars) {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    private static void printWinners(List<String> winners) {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i));
            if (i < winners.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
