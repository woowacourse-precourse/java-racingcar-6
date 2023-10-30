package racingcar;

import java.util.List;
import java.util.Map;
import racingcar.model.car.Car;

public class View {

    public static final String GAME_START_MESSAGE = "영문으로만 이루어진 " +
            InputConfig.NAME_LENGTH_MIN + "이상 " +
            InputConfig.NAME_LENGTH_MAX + "이하의 이름을" +
            InputConfig.NAME_DELIMITER + "로 구분하여 입력하세요.";
    public static final String RACE_START_MESSAGE = "실행 결과";
    private static final String JOIN_DELIMITER = ", ";
    public static String DISTANCE_MARK = "-";

    public static void printRaceResult(Map<Car, Integer> map) {
        map.entrySet().stream().forEach(entry -> {
            String name = entry.getKey().getCarName().name();
            Integer value = entry.getValue();

            System.out.println(name + " : " + DISTANCE_MARK.repeat(value));
        });
        System.out.println();
    }

    public static void gameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void raceStartMessage() {
        System.out.println(RACE_START_MESSAGE);
    }

    public static void roundInputMessage() {
        String message = InputConfig.RACE_INPUT_MIN + "이상의 숫자를 입력하세요";
        System.out.println(message);
    }

    public static void printWinners(List<String> winnersNames) {
        String message = "최종 우승자 : " + String.join(JOIN_DELIMITER, winnersNames);
        System.out.println(message);
    }
}
