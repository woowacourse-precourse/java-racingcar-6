package racingcar.view;

import static racingcar.message.OutputMessage.*;

public class OutputView {

    public void outputLineBreak() {
        System.out.println(LINE_BREAK.getMessage());
    }

    public void outputResultMessage() {
        outputLineBreak();
        System.out.println(RESULT_MESSAGE.getMessage());
    }

    public void outputResult(String name, int distance) {
        String result = BAR.getMessage().repeat(distance);
        System.out.println(name+SEPARATOR.getMessage()+result);
    }

    public void outputWinner(String name) {
        System.out.println(WINNER.getMessage()+name);
    }
}
