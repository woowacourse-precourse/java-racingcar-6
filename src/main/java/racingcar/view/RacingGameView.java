package racingcar.view;

import racingcar.constant.GameMessages;
import racingcar.model.Cars;

import java.util.List;

public class RacingGameView {
    public void printGameStartMessage(){
        System.out.println(GameMessages.INPUT_CAR_NAMES.getMessage());
    }
    public void printExecutionMessage(){
        System.out.println(GameMessages.RESULT.getMessage());
    }
    public void printGameResultMessage(List<String> winners){
        System.out.print(GameMessages.GAME_RESULT.getMessage());
        printGameResultDetailMessage(winners);

    }
    public void printGameResultDetailMessage(List<String> winners){
        System.out.println(String.join(", ", winners));
    }
    public void printRepeatCountMessage(){
        System.out.println(GameMessages.INPUT_REPEAT_COUNT.getMessage());
    }
    public void printGameProcessingMessage(Cars cars){
        System.out.println(cars.toString());
    }


}
