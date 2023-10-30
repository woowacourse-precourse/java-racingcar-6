package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public interface GameView {
    
    public String getUserInput();

    public void printInputCars();

    public void printInputMoveCount();

    public void printExecutionStart();

    public void printMoveResult(List<Car> cars);

    public void printFinalWinner(List<String> winners);
}
