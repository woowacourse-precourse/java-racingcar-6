package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {
    public static void printPlayMessage() {
        System.out.println("실행 결과");
    }

    public static void printRoundResult(List<Car> carStatuses) {
        carStatuses.forEach(OutputView::printCarStatus);
    }

    private static void printCarStatus(Car car) {
        System.out.println(car.getName() + " : " + getStatusRepresentation(car.getPosition()));
    }

    private static String getStatusRepresentation(int position) {
        return "-".repeat(position);
    }

    public static void printWinner(List<Car> winners) {
        String winnerNames = String.join(", ", winners.stream()
                .map(Car::getName)
                .toList());
        System.out.println("최종 우승자 : " + winnerNames);
    }

    public static void printNewLine() {
        System.out.println();
    }
}
