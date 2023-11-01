package racingcar.view;

import racingcar.util.messages.Messages;

import java.util.List;

public class OutputView {
    public void printEmptyLine() {
        System.out.println();
    }

    public void printGameResultTitle() {
        System.out.println(Messages.GAME_RESULT_TITLE.getMessage());
    }

    public void printGameResultProgressBar(String carName, int distance) {
        StringBuilder sb = new StringBuilder();
        sb.append(carName).append(Messages.DELIMITER_CAR_NAME_AND_PROGRESSBAR.getMessage());
        for (int i = 0; i < distance; i++) {
            sb.append(Messages.PROGRESS_BAR.getMessage());
        }
        System.out.println(sb);
    }

    public void printGameWinnerName(List<String> winners) {
        System.out.println(Messages.WINNER_ANNOUNCE_TITLE.getMessage()
                + String.join(", ", winners));
    }
}
