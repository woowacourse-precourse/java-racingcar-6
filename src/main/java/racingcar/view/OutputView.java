package racingcar.view;

import racingcar.domain.Cars;

public class OutputView {

    private static final String MOVE_MESSAGE = "-";
    private static final String LINE_BREAK = System.lineSeparator();

    public static void printPlayResult() {
        System.out.println("실행 결과");
    }

    public static void printResult(Cars cars) {
        cars.getCars()
                .forEach(car -> System.out.println(car.getName() + " : " + MOVE_MESSAGE.repeat(car.getPosition())));
        System.out.print(LINE_BREAK);
    }
}
