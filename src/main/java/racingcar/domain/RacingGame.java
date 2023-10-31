package racingcar.domain;

import racingcar.message.GameMessage;
import racingcar.util.CarGenerator;
import racingcar.view.OutputView;
import racingcar.view.Inputview;
public class RacingGame {

    public void start(){
        printRequestNames();
        generateCars();
        printRequestNumber();



    }

    private void printRequestNames(){
        OutputView.consoleLine(GameMessage.INSERT_NAME_MESSAGE);
    }

    private void printRequestNumber(){
        OutputView.consoleLine(GameMessage.INSERT_TURN_MESSAGE);
    }

    private void generateCars(){
        CarGenerator carGenerator = new CarGenerator(Inputview.consoleLine());
        carGenerator.splitNames();
        carGenerator.generateCars();
    }


}
