package racingcar.view;

import racingcar.domain.Car;
import racingcar.util.messages.Messages;

import java.util.List;

public class OutputView {
    public void printGameResultTitle() {
        System.out.println(Messages.GAME_RESULT_TITLE.getMessage());
    }

    public void printCarPosition(List<Car> carList) {
        StringBuilder sb = new StringBuilder();
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
}
