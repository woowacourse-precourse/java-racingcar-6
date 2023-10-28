package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import static constant.MessgeList.INPUT_MESSAGE;

public class InputView {
    public String getInputFromPlayer(){
        System.out.println(INPUT_MESSAGE);
        return Console.readLine();
    }
}
