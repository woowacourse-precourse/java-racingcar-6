package racingcar.view;

import java.util.List;

public class OutputView {
    public static void printMessage(IOMessage ioMessage) {
        System.out.println(ioMessage.getMessage());
    }

    public static void printExecutionResult(List<String> executionList) {
        StringBuilder playResult = new StringBuilder();
        executionList.forEach(playResult::append);
        System.out.println(playResult);
    }
}
