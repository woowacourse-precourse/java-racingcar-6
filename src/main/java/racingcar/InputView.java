package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String receiveCarNames(){
        OutputView.printInputMsg();
        return Console.readLine();
    }

    public static String getRound(){
        OutputView.printRetryNumMsg();
        return Console.readLine();
    }
}
