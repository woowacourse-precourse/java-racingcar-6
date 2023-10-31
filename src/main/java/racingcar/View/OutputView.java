package racingcar.View;

import java.util.List;
import java.util.Map;
import racingcar.Global.Constants;

public class OutputView {


    public void printEachStageResult(Map<String, Integer> results) {
        results.forEach((name, step) -> {
            System.out.println(makeResultState(name, step));
        });
    }

    private String makeResultState(String carName, int step) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(carName + " : ");
        for (int i = 0; i < step; i++) {
            stringBuilder.append(Constants.stepSymbol);
        }
        return stringBuilder.toString();
    }

    public void printString(String str) {
        System.out.println(str);
    }

    private String makeWinnerState(List<String> winnerNames) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Constants.gameWinnerState + " :");
        for (String name : winnerNames) {
            stringBuilder.append(" " + name + ",");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    public void printWinner(List<String> winnerNames) {
        System.out.println(makeWinnerState(winnerNames));
    }
}
