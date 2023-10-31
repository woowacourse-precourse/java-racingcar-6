package racingcar.view;

import java.util.List;
import racingcar.domain.Cars;

public class OutputView {

    private static final String MOVE_MESSAGE = "-";
    private static final String LINE_BREAK = System.lineSeparator();

    private OutputView() {
    }

    public static void printPlayResultMessage() {
        System.out.print(LINE_BREAK);
        System.out.println("실행 결과");
    }

    public static void printResult(Cars cars) {
        cars.getCars()
                .forEach(car -> System.out.println(car.getName() + " : " + MOVE_MESSAGE.repeat(car.getPosition())));
        System.out.print(LINE_BREAK);
    }

    public static void printWinner(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
