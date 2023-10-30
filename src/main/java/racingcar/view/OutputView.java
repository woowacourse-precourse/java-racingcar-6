package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {

    public static void printRaceStartMessage() {
        System.out.println("\n실행 결과");
    }

    public static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            printCarPosition(car);
        }

        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        String winnersString = String.join(", ", winners);
        System.out.println("최종 우승자 : " + winnersString);
    }

    private static void printCarPosition(Car car) {
        System.out.print(car.getName() + " : ");

        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }

        System.out.println();
    }


}
