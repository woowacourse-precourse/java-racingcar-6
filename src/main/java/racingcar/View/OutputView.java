package racingcar.View;

import java.util.List;
import java.util.StringJoiner;
import racingcar.Domain.ProgressBoard;

public class OutputView {
    private final String RESULT_MESSAGE = "실행 결과";
    private final String FINAL_WINNER = "최종 우승자 : ";
    private final String DELIMITER = ", ";
    private final String COLON = " : ";

    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printFinalWinner(List<String> winners) {
        StringJoiner stringJoiner = new StringJoiner(DELIMITER);
        for (String winner : winners) {
            stringJoiner.add(winner);
        }
        System.out.println(FINAL_WINNER + stringJoiner);
    }

    public void printProgressMessage(List<String> cars, List<String> progress) {
        for (int i = 0; i < cars.size(); i++) {
            System.out.println(cars.get(i) + COLON + progress.get(i));
        }
        System.out.println();
    }
}
