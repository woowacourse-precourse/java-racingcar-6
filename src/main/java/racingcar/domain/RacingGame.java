package racingcar.domain;

import racingcar.message.GameMessage;
import racingcar.util.CarGenerator;
import racingcar.view.OutputView;
import racingcar.view.Inputview;
public class RacingGame {

    private void start(){
        printRequestNames();
        CarGenerator carGenerator = new CarGenerator(Inputview.consoleLine());
        printRequestNumber();
        String turns = Inputview.consoleLine();


    }

    private void printRequestNames(){
        OutputView.consoleLine(GameMessage.INSERT_NAME_MESSAGE);
    }

    private void printRequestNumber(){
        OutputView.consoleLine(GameMessage.INSERT_TURN_MESSAGE);
    }


}
