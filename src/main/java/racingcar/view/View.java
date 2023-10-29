package racingcar.view;

import config.CarConfig;
import java.util.List;
import racingcar.model.car.Car;

public class View {
    private static final String GAME_START_MESSAGE =
            CarConfig.NAME_MIN_LENGTH + "에서 " +
            CarConfig.NAME_MAX_LENGTH + "까지 길이의 영문으로 이루어진 이름을 각각 " +
            CarConfig.INPUT_NAME_DELIMITER + "로 구분하여 입력하세요.";
    private static final String ROUND_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RACE_START_MESSAGE = "실행 결과";
    private static final String DISTANCE_MARK = "-";

    public static void print(Car car, int distance) {
        String name = car.getCarName().getName();
        System.out.println(name + " : " + DISTANCE_MARK.repeat(distance));
    }

    public static void gameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }
    public static void raceStartMessage() {
        System.out.println(ROUND_COUNT_MESSAGE);
    }

    public static void RaceStartMessage() {
        System.out.println(RACE_START_MESSAGE);
    }

    public static void printWinner(List<String> winnerCarName) {
        String winners = String.join(", ", winnerCarName);
        System.out.println("최종 우승자 : " + winners);
    }
}
