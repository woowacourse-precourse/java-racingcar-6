package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {
    private static final String NAME_INPUT_DESC = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String MOVE_COUNT_INPUT_DESC = "시도할 회수는 몇회인가요?";
    private static final String RESULT_DESC = "실행 결과";
    private static final String WINNER_DESC = "최종 우승자 : ";

    public static void printNameInputDescription() {
        System.out.println(NAME_INPUT_DESC);
    }

    public static void printMoveCountInputDescription() {
        System.out.println(MOVE_COUNT_INPUT_DESC);
    }

    public static void printResultDescription() {
        System.out.println(RESULT_DESC);
    }

    public static void printRoundStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.println(WINNER_DESC + String.join(", ", winners));
    }
}
