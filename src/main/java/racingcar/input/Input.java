package racingcar.input;

import java.util.List;
import racingcar.Car;

public interface Input {

    List<Car> receiveCarNamesAndMakeList();

    int receiveTotalCountOfExecution();
}
