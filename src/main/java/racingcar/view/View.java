package racingcar.view;

import java.util.List;
import java.util.Map;
import racingcar.model.car.Car;

public class View {
    private static final String JOIN_DELIMITER = ", ";
    private static final String DISTANCE_MARK = "-";

    public static void printRaceResult(Map<Car, Integer> map) {
        map.entrySet().stream().forEach(entry -> {
            String name = entry.getKey().getName();
            Integer value = entry.getValue();

            System.out.println(name + " : " + DISTANCE_MARK.repeat(value));
        });
        System.out.println();
    }

    public static void printWinners(List<String> winnersNames) {
        String message = "최종 우승자 : " + String.join(JOIN_DELIMITER, winnersNames);
        System.out.println(message);
    }
}
