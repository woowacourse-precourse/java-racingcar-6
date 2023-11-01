package racingcar.view;

import static racingcar.constants.Message.FINAL_WINNER;
import static racingcar.constants.Message.MOVE_PROGRESS;
import static racingcar.constants.Message.RESULT;

import java.util.List;
import racingcar.dto.Progress;

public class OutputView {
    private final String BAR_SIGNATURE = "-";
    private final String DELIMITER = ", ";


    public void printProgress(List<Progress> progressList) {
        for (Progress progress : progressList) {
            String distance = getDistanceBar(progress.distance());
            System.out.println(String.format(MOVE_PROGRESS.toString(), progress.carName(), distance));
        }
        System.out.print("\n");
    }

    private String getDistanceBar(int distance) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < distance; ++i) {
            builder.append(BAR_SIGNATURE);
        }
        return builder.toString();
    }

    public void printWinners(List<String> winners) {
        System.out.println(String.format(FINAL_WINNER.toString(), String.join(DELIMITER, winners)));
    }

    public void printResultHeader() {
        System.out.println(RESULT);
    }
}
