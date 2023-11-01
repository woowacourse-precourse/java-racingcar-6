package racingcar.view;

import racingcar.utils.constant.message.InputMessage;
import racingcar.utils.constant.message.OutputMessage;

import java.util.List;

public class OutputView {
    public void carNameMessage(){
        System.out.println(InputMessage.CAR_NAME);
    }

    public void countMessage(){
        System.out.println(InputMessage.COUNT);
    }

    public void roundResultMessage(){
        System.out.println("\n" + OutputMessage.RESULT);
    }

    public void carPositionMessage(String name, int position){
        System.out.println(name + " : " + OutputMessage.DISTANCE.repeat(position));
    }
    public void blank(){
        System.out.println("");
    }
    public void winnerMessage(List<String> name){
        System.out.println(OutputMessage.WINNER +  " : " + String.join(",", name));
    }

}
