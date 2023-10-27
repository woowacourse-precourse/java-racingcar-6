package racingcar.view;

import racingcar.constant.Message;
import racingcar.model.Car;

import java.util.List;

public class OutputView {

    public OutputView() {}

    public void printWinner(List<String> winners) {
        String winner = String.join(", ", winners);
        System.out.println(Message.WINNER_MESSAGE + winner);
    }
}
