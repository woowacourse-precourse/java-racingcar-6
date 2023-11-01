package racingcar.view;

import java.util.List;
import racingcar.model.MessageEnum;

public class OutputMessage {
    private static final int WINNER_COUNT = 1;

    public void resultMessage() {
        System.out.println(MessageEnum.RESULT_MESSAGE.getMessage());
    }

    public void raceStatusMessage(List<String> carNames, List<Integer> movement) {
        for (int i = 0; i < carNames.size(); i++) {
            System.out.println(carNames.get(i) + " : " + MessageEnum.MOVEMENT.getMessage().repeat(movement.get(i)));
        }
        System.out.println();

    }

    public void winnerMessage(List<String> winner) {
        System.out.print(MessageEnum.WINNER_MESSAGE.getMessage());

        if (winner.size() == WINNER_COUNT) {
            System.out.println(winner.get(0));
        }
        if (winner.size() > WINNER_COUNT) {
            String winnerList = String.join(", ", winner);
            System.out.println(winnerList);
        }
    }
}
