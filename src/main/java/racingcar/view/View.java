package racingcar.view;

import Config.AppConfig;
import java.util.List;
import racingcar.model.Car.Car;

public class View {
    private static final String GAME_START_MESSAGE =
            AppConfig.NAME_MIN_LENGTH + "에서 " +
            AppConfig.NAME_MAX_LENGTH + "까지 길이의 영문으로 이루어진 이름을 각각 " +
            AppConfig.INPUT_NAME_DELIMITER + "로 구분하여 입력하세요.";
    private static final String ROUND_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String ROUND_START_MESSAGE = "실행 결과";
    private static final String DISTANCE_MARK = "-";

    public void print(Car car, int distance) {
        String name = car.getCarName().getName();
        System.out.println(name + " : " + DISTANCE_MARK.repeat(distance));
    }

    public static void gameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }
    public static void processStartMessage() {
        System.out.println(ROUND_COUNT_MESSAGE);
    }

    public static void roundStartMessage() {
        System.out.println(ROUND_START_MESSAGE);
    }

    public void printWinner(List<String> winnerCarName) {
        String winners = String.join(", ", winnerCarName);
        System.out.println("최종 우승자 : " + winners);
    }
}
