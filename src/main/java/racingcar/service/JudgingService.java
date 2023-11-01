package racingcar.service;

import java.util.List;

import racingcar.domain.Car;

public interface JudgingService {
    String determineWinner();

    int findMaxPosition(List<Car> cars);
}
