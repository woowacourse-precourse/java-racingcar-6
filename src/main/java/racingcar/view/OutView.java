package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutView {

    private static final String EXECUTION_RESULT = "실행 결과";
    private static final String FORWARDING_LETTER = "-";
    private static final String INTRODUCING_WINNERS = "최종 우승자 : ";

    public static void printExecutionStart() {
        System.out.println();
        System.out.println(EXECUTION_RESULT);
    }

    public static void printCarsMovingResult(List<Car> cars) {
        cars.forEach(OutView::printOneCarMovingResult);
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.print(INTRODUCING_WINNERS);
        System.out.println(winnersToString(winners));
    }

    private static void printOneCarMovingResult(Car car) {
        System.out.println(car.getName() + " : " + movingCountToString(car));
    }

    private static String movingCountToString(Car car) {
        return FORWARDING_LETTER.repeat(car.getMoveCount());
    }

    private static String winnersToString(List<String> winners) {
        return String.join(", ", winners);
    }

}
