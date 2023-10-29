package racingcar.view;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.util.Constants;

public class OutputView {

    private boolean isFirstTime = true;

    public void printMoveResult(Map<Car, Integer> moveResults) {
        printGameResultMessageForFirstTime();

        for (Car car : moveResults.keySet()) {
            String position = converterPosition(car.getPosition());
            System.out.printf("%s : %s\n", car.getName(), position);
        }
        System.out.println();
    }

    private void printGameResultMessageForFirstTime() {
        if (!isFirstTime) {
            return;
        }

        System.out.println("\n" + Constants.GAME_RESULT_MESSAGE);
        this.isFirstTime = false;
    }

    public void printWinner(List<String> winnerList) {
        if (winnerList.size() > 1) {
            String winners = winnerList.stream().collect(Collectors.joining(", "));
            System.out.println(Constants.GAME_WINNER_MESSAGE + winners);
            return;
        }

        String winner = winnerList.get(0);
        System.out.println(Constants.GAME_WINNER_MESSAGE + winner);
    }

    private String converterPosition(final int position) {
        return "-".repeat(position);
    }
}
