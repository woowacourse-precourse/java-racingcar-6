package racingcar.view;

import java.util.List;

public interface OutputView {

    public void printEachCarResult(String s,int moveCount);

    public void printLineSpace();

    public void printResult();

    public void printWinner(List<String> names);
}
