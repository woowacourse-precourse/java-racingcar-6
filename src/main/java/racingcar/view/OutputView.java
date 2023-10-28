package racingcar.view;

import racingcar.domain.Car;
import racingcar.util.messages.Messages;

import java.util.List;

public class OutputView {
    StringBuilder sb;

    public void printGameResultTitle() {
        System.out.println(Messages.GAME_RESULT_TITLE.getMessage());
    }

    public void printCarPosition(List<Car> carList) {
        sb = new StringBuilder();
        for (int i = 0; i < carList.size(); i++) {
            int distance = carList.get(i).getDistance();
            sb.append(carList.get(i).getName()).append(" : ");
            for (int j = 0; j < distance; j++) {
                sb.append("-");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public void printEmptyLine() {
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        sb = new StringBuilder();
        sb.append("최종 우승자 : ");
        if (winners.size() > 1) {
            for (int i = 0; i < winners.size(); i++) {
                sb.append(winners.get(i)).append(", ");
            }
        } else {
            sb.append(winners.get(0));
        }
        System.out.println(sb);
    }
}
