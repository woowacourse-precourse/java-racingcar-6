package racingcar.view;

import java.util.List;
import racingcar.Car;

public class OutputView {

    private static final String GAME_START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String PROMPT_MESSAGE = "시도할 회수는 몇 회인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";
    private static final String COUNT_SYMBOL = "-";

    public static void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void printPromptMessage() {
        System.out.println(PROMPT_MESSAGE);
    }

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printResult(List<Car> cars) {
        for (Car car : cars) {
            printCarName(car);
            printCarMoveNum(car);
        }
        System.out.println();
    }

    private static void printCarName(Car car) {
        System.out.print(car.getName() + " : ");
    }

    private static void printCarMoveNum(Car car) {
        for (int i = 0; i < car.getMoveNum(); i++) {
            System.out.print(COUNT_SYMBOL);
        }
        System.out.println();
    }
}
