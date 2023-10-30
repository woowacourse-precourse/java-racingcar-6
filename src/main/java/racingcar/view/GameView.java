package racingcar.view;

import java.util.List;

public interface GameView {

    public String getUserInput();

    public void printInputCars();

    public void printInputMoveCount();

    public void printExecutionStart();

    public void printMoveResult(List<String> status);

    public void printFinalWinner(String result);
}
