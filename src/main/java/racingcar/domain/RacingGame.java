package racingcar.domain;

import racingcar.message.GameMessage;
import racingcar.view.OutputView;
import racingcar.message.GameMessage.*;
public class RacingGame {

    private void start(){
        printRequestNames();


    }

    private void printRequestNames(){
        OutputView.consoleLine(GameMessage.INSERT_NAME_MESSAGE);
    }

    private void printRequestNumber(){
        OutputView.consoleLine(GameMessage.INSERT_TURN_MESSAGE);
    }


}
