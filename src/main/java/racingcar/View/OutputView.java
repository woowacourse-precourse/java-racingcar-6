package racingcar.View;

import java.util.List;
import java.util.Map;
import racingcar.Global.Constants;

public class OutputView {
    public static final String stepSymbol = "-";

    public void printEachStageResult(Map<String, Integer> results) {
        results.forEach((name, step) -> {
            System.out.println(makeResultState(name, step));
        });
    }

    private String makeResultState(String name, int step) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name);
        stringBuilder.append(" : ");
        for (int i = 0; i < step; i++) {
            stringBuilder.append(stepSymbol);
        }
        return stringBuilder.toString();
    }

    public void printString(String str) {
        System.out.println(str);
    }

    public void printWinner(List<String> names) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Constants.gameWinnerState);
        stringBuilder.append(" :");
        for (String name : names) {
            stringBuilder.append(" ");
            stringBuilder.append(name);
            stringBuilder.append(",");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        System.out.println(stringBuilder.toString());
    }
}
