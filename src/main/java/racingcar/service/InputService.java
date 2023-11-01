package racingcar.service;


import java.util.List;

public interface InputService<T> {
    List<T> inputCarName();

    int inputTimes();
}
