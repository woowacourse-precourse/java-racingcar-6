package racingcar.view;

import racingcar.model.Car;
import racingcar.util.messages.Messages;

import java.util.List;

public class OutputView {
    StringBuilder sb;

    public void printGameResultTitle() {
        System.out.println(Messages.GAME_RESULT_TITLE.getMessage());
    }

    public void printCarPosition(List<Car> carList) {
        sb = new StringBuilder();
        printCarRaceProgress(carList);
        System.out.println(sb);

    }

    private void printCarRaceProgress(List<Car> carList) {
        for (int i = 0; i < carList.size(); i++) {
            int distance = carList.get(i).getDistance();
            sb.append(carList.get(i).getName()).append(" : ");
            printCarRaceProgressBar(distance);
        }
    }

    private void printCarRaceProgressBar(int distance) {
        for (int j = 0; j < distance; j++) {
            sb.append("-");
        }
        sb.append('\n');
    }

    public void printEmptyLine() {
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        sb = new StringBuilder();
        sb.append("최종 우승자 : ");
        printWinnersByLength(winners);
        System.out.println(sb);
    }

    private void printWinnersByLength(List<String> winners) {
        if (winners.size() > 1) {
            printWinnersName(winners);
        } else {
            printWinnerName(winners);
        }
    }

    private void printWinnerName(List<String> winners) {
        sb.append(winners.get(0));
    }

    private void printWinnersName(List<String> winners) {
        for (int i = 0; i < winners.size(); i++) {
            sb.append(winners.get(i)).append(", ");
        }
    }
}
