package racingcar.view;

import java.util.List;
import racingcar.dto.CarStateDto;

public interface Output {
    void printCarNamesInputRequest();
    void printMoveCountInputRequest();
    void printCarsState(List<CarStateDto> carStateDtoList);
    void printResultStartedMessage();
    void printWinner(List<String> winnerNameList);
}
