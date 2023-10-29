package racingcar;

import java.util.List;
import racingcar.dto.CarDto;

public interface CarRacing {
    void addCar(String[] carNames);
    void addNumberOfRace(int nuber);
    List<CarDto> progress();
    List<CarDto> getWinner();

}
