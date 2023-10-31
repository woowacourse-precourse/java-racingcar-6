package racingcar.view;

import java.util.ArrayList;
import racingcar.domain.Car;

public class OutputView {
    public static void printStartGameMessage() {
        System.out.println("\n실행 결과");
    }

    public static void printRoundResult(ArrayList<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            printPosition(car);
            System.out.println();
        }
        System.out.println();
    }

    private static void printPosition(Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
    }

    public static void printWinners(ArrayList<String> winners) {
        System.out.print("최종 우승자 : " + String.join(", ", winners));
    }
}
