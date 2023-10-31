package racingcar.view;

import racingcar.enums.Common;
import racingcar.model.Car;

import java.util.List;

public class OutputView {
    private static final String DISTANCE_MARK = "-";

    public static void printCarNameInputMessage() {
        System.out.printf("경주할 자동차 이름을 입력하세요.(이름은 쉼표(%s) 기준으로 구분)%n", Common.SEPARATOR.getStringValue());
    }

    public static void printNumberOfAttemptsInputMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printPlayResultMessage() {
        System.out.println("실행 결과");
        System.out.println();
    }

    public static void printPlayResult(List<Car> playResults) {
        for (Car car : playResults) {
            System.out.printf("%s : %s%n", car.getName(), DISTANCE_MARK.repeat(Math.max(0, car.getDistance())));
        }
        System.out.println();
    }

    public static void printWinners(List<String> winnerNames) {
        System.out.printf("최종 우승자 : %s", String.join(Common.SEPARATOR.getStringValue() + " ", winnerNames));
    }
}
