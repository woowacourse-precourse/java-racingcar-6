package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.message.RaceMessage;

public class InputView {

    public String getCars(){
        System.out.println(RaceMessage.CARS_INPUT_MESSAGE);
        return Console.readLine();
    }
}
