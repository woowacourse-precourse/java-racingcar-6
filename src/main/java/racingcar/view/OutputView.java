package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {
    private static final int SOLO = 1;
    private static final String WINNERS_LIST = "최종 우승자 : ";

    public static void printScore(List<Car> cars) {
        for (Car car : cars) {
            printScoreOfCars(car);
        }
        System.out.println();
    }

    public static void printWinner(List<String> carNames) {
        System.out.print(WINNERS_LIST);
        System.out.print(carNames.get(0));
        if (carNames.size() > SOLO) {
            printCarNames(carNames);
        }
        System.out.println();
    }

    private static void printCarNames(List<String> carNames) {
        for (int i = 1; i < carNames.size(); i++) {
            System.out.print(", ");
            System.out.print(carNames.get(i));
        }
    }

    private static void printScoreOfCars(Car car) {
        System.out.print(car.getName() + " : ");
        printPosition(car);
        System.out.println();
    }

    private static void printPosition(Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
    }
}
