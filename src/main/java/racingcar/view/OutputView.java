package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {

    private static final String ENTER_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ENTER_ATTEMPTS_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String ONE_STEP = "-";
    private static final String RESULT_MESSAGE = "실행 결과";

    public static void enterCarNames() {
        System.out.println(ENTER_CAR_NAME_MESSAGE);
    }

    public static void enterAttempts() {
        System.out.println(ENTER_ATTEMPTS_MESSAGE);
    }

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printResult(List<Car> carList) {
        for (Car car : carList) {
            printPosition(car);
        }
        System.out.println();
    }

    public static void printPosition(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print(ONE_STEP);
        }
        System.out.println();
    }

    public static void printWinners(List<Car> winners) {
        System.out.print("최종 우승자 : ");
        for (Car car : winners) {
            System.out.print(car.getName());
            if (winners.indexOf(car) != winners.size() - 1) {
                System.out.print(",");
            }
        }
        System.out.println();
    }

}
