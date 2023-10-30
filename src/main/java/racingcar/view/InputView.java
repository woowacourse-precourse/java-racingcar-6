package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String getCarName(){
        OutputView.inputMessage();
        return Console.readLine();
    }

    public static String getRound(){
        OutputView.repeatNumMessage();
        return Console.readLine();
    }
}