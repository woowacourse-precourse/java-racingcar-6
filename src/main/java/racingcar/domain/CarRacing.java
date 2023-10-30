package racingcar.domain;

import java.util.List;
import racingcar.dto.CarDto;
import racingcar.dto.RaceConditionDto;

public interface CarRacing {
    void addCar(String[] carNames);
    void addNumberOfRace(int nuber);
    RaceConditionDto start();
    List<CarDto> getWinner();

}
