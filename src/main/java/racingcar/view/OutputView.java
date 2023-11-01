package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {

    private static final int SOLO = 1;

    public static void printHeader() {
        System.out.println("실행 결과");
    }

    public static void printCarScores(List<Car> cars) {
        for (Car car : cars) {
            printCarScore(car);
        }
        System.out.println();
    }

    public static void printWinners(List<String> winningCarNames) {
        System.out.print("최종 우승자 : ");
        System.out.print(winningCarNames.get(0));
        if (isSoloWin(winningCarNames)) {
            System.out.println();
            return;
        }
        for (int i = 1; i < winningCarNames.size(); i++) {
            System.out.print(", ");
            System.out.print(winningCarNames.get(i));
        }
        System.out.println();
    }

    public static void printException(String message) {
        System.out.println(message);
    }

    private static void printCarScore(Car car) {
        System.out.print(car.getName() + " : ");
        printPosition(car);
        System.out.println();
    }

    private static void printPosition(Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
    }

    private static boolean isSoloWin(List<String> winningCarNames) {
        return winningCarNames.size() == SOLO;
    }
}
