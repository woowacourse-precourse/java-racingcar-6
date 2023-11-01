package racingcar.view;

import racingcar.message.InputMessage;
import racingcar.message.OutputMessage;

import java.util.List;

public class OutputView {
    public void printWinner(List<String> winner) {
        System.out.println(OutputMessage.WINNER.getMsg() + String.join(InputMessage.CARS_DELIMITER.getMsg(), winner));
    }

    public void printEachForward(String carName, Integer carPlace) {
        String carPlaceHyphen = OutputMessage.CAR_FORWARD_PLACE.getMsg();
        System.out.println(carName + " : " + carPlaceHyphen.repeat(carPlace));
    }
}
