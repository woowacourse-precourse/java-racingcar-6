package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {

    public static void printResultMessage() {
        System.out.println("실행 결과");
    }

    public static void printCarScore(List<Car> cars) {

        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            printCarPosition(car);
        }
        System.out.println();
    }

    public static void printCarPosition(Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }


    public static void printSoloWin(String winner) {
        System.out.println("최종 우승자 : " + winner);
    }

    public static void printWinners(List<String> winners) {
        System.out.print("최종 우승자 : ");
        for (String winner : winners) {
            System.out.print(winner);
            System.out.print(", ");
        }
    }

}
