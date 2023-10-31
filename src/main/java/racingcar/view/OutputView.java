package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.List;

public class OutputView {
    private static final String CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String GAME_TRY_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String GAME_EXECUTION_MESSAGE = "실행 결과";
    private static final String GAME_RESULT_MESSAGE = "최종 우승자 : ";
    private static final String MARK_REGEX = "-";

    private OutputView() {}

    public static void outputCarNameMessage() {
        System.out.println(CAR_NAME_MESSAGE);
    }

    public static void outputGameTryMessage() {
        System.out.println(GAME_TRY_MESSAGE);
    }

    public static void outputGameStartMessage() {
        System.out.println(GAME_EXECUTION_MESSAGE);
    }

    public static void outputEachStage(Cars cars) {
        List<Car> list = cars.getCars();
        for (Car car : list) {
            System.out.println(car.getName() + " : " + repeatMarkRegex(car.getPosition()));
        }
        System.out.println();
    }

    private static String repeatMarkRegex(int count) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<count; i++) {
            sb.append(MARK_REGEX);
        }
        return sb.toString();
    }

    public static void outputGameResultMessage() {
        System.out.print(GAME_RESULT_MESSAGE);
    }

    public static void outputGameResult(List<Car> winners) {
        StringBuilder sb = new StringBuilder();
        for (Car winner : winners) {
            sb.append(winner.getName()).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        System.out.print(sb);
    }
}
