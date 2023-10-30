package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class View {
    private static final int SOLO = 1;

    public static void printScore(List<Car> cars) {
        for (Car car : cars) {
            printScoreOfCars(car);
        }
        System.out.println();
    }

    public static void printWinner(List<String> carNames) {
        System.out.print("최종 우승자 : ");
        System.out.print(carNames.get(0));
        if (carNames.size() > SOLO) {
            for (int i = 1; i < carNames.size(); i++) {
                System.out.print(", ");
                System.out.print(carNames.get(i));
            }
        }
        System.out.println();
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
