package racingcar.model.service;

import java.util.List;
import racingcar.dto.Car;

public interface CarService {
    void registerCarLineUp(String carNames);
    void registerTryCount(String tryCount);
    void goOrStop();
    List<Car> showCarLineupInfo();
    boolean isRacingcarStop();
}
