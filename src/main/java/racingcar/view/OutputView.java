package racingcar.view;

import java.util.List;
import racingcar.dto.CarCondition;

public class OutputView {
    public static final String RACE_RESULT_MESSAGE = "실행 결과";

    public static void sendResult() {
        System.out.println(RACE_RESULT_MESSAGE);
    }

    public static void sendRaceCondition(CarCondition carCondition) {
        List<String> names = carCondition.names();
        List<Integer> positions = carCondition.positions();
        for (int carNumber = 0; carNumber < names.size(); carNumber++) {
            System.out.println(names.get(carNumber) + " : " + positions.get(carNumber));
        }
    }
}
