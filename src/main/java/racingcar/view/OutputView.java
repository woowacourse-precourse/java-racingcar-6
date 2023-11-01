package racingcar.view;

import java.util.List;
import racingcar.Message;

public class OutputView {
    public void printMessage(String message) {
        System.out.print(message);
    }

    public void printCarResult(String carName, String carResult) {
        System.out.println(carName + " : " + carResult);
    }

    public void printWinnerList(List<String> winnerList) {
        System.out.println(Message.GAME_WINNER.getMessage() + String.join(", ", winnerList));
    }
}
