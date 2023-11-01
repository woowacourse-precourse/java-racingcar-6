package racingcar;

import java.util.List;

public class OutputView {

    public static void printHeader() {
        System.out.println("\n실행 결과");
    }

    public static void printRound(List<Car> cars) {
        for (Car car : cars) {
            printCarPosition(car);
        }
        System.out.println();
    }

    private static void printCarPosition(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printWinners(List<Car> winners) {
        System.out.print("최종 우승자 : ");
        StringBuilder winnerNames = new StringBuilder();
        for (int i = 0; i < winners.size(); i++) {
            winnerNames.append(winners.get(i).getName());
            if (i != winners.size() - 1) { // Not the last element
                winnerNames.append(", ");
            }
        }
        System.out.println(winnerNames.toString());
    }
}
