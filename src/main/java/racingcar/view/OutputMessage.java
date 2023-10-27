package racingcar.view;

import java.util.List;
import racingcar.model.MessageEnum;

public class OutputMessage {
    public void resultMessage() {
        System.out.println(MessageEnum.RESULT_MESSAGE.getMessage());
    }

    public void raceStatusMessage(List<String> carNames, List<Integer> movement) {
        for (int i = 0; i < carNames.size(); i++) {
            System.out.println(carNames.get(i) + " : " + MessageEnum.MOVEMENT.getMessage().repeat(movement.get(i)));
        }
        System.out.println();

    }
}
