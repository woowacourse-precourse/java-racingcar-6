package racingcar.model.service;

public interface CarService {
    void registerCarLineUp(String carNames);
    void registerTryCount(String tryCount);

    void goOrStop();
}
