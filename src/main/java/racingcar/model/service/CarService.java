package racingcar.model.service;

import java.util.List;
import racingcar.dto.Car;

public interface CarService {
    void registerCarLineUp(String carNames);
    void registerTryCount(String tryCount);
    void goOrStop();
    boolean isRacingcarStop();
    List<Car> getCarLineupInfo();
    List<String> getWinnerNames();
}
