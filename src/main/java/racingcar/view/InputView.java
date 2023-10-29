package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String readCarNames(){
        OutputView.printCarNamePrompt();
        String input = Console.readLine();
        return input;
    }


}
