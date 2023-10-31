package racingcar.view;

import java.util.List;
import racingcar.util.Message;

public class OutputView {
    public OutputView() {
    }

    public static OutputView getInstance() {

        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final OutputView INSTANCE = new OutputView();
    }

    public void printMessage(Message message) {
        println(message.getMessage());
    }

    public void printOneRoundResult(List<String> results) {
        for (String result : results) {
            println(result);
        }
        println("");
    }

    private void println(String output) {
        System.out.println(output);
    }
}
