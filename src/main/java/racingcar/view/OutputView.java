package racingcar.view;

import java.util.List;
import racingcar.dto.CarCondition;
import racingcar.dto.RaceResult;

public class OutputView {
    public static final String RACE_RESULT_MESSAGE = "실행 결과";
    public static final String WINNERS = "최종 우승자 : ";

    public static void sendResultStart() {
        System.out.println();
        System.out.println(RACE_RESULT_MESSAGE);
    }

    public static void sendRaceCondition(CarCondition carCondition) {
        List<String> names = carCondition.names();
        List<Integer> positions = carCondition.positions();
        for (int carNumber = 0; carNumber < names.size(); carNumber++) {
            System.out.println(names.get(carNumber) + " : " + toBars(positions.get(carNumber)));
        }
        System.out.println();
    }

    private static String toBars(int position) {
        return "-".repeat(position);
    }

    public static void sendWinners(RaceResult raceResult) {
        System.out.println(WINNERS + createWinnersMessage(raceResult.winners()));
    }

    private static String createWinnersMessage(List<String> winners) {
        return String.join(", ", winners);
    }
}
