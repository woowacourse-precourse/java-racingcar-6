package racingcar.view;

import java.util.List;
import racingcar.domain.dto.CarDto;

public interface GameView {

    public String getUserInput();

    public void printInputCars();

    public void printInputMoveCount();

    public void printExecutionStart();

    public void printMoveResult(List<CarDto> cars);

    public void printFinalWinner(List<String> winners);
}
