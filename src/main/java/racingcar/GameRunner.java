package racingcar;

import racingcar.dto.InputDTO;
import racingcar.view.InputView;

public class GameRunner {

    public static void playGame() {
        InputDTO inputDTO = InputView.readUserInput();

        String[] names = inputDTO.names();
        Racing racing = Racing.createRacing(names);

        int count = inputDTO.trialCount();
        for (int i = 0; i < count; i++) {
            racing.playRacing();
        }
    }
}
