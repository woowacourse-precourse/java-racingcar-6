package racingcar.repository;


import java.util.List;

public interface Repository<T> {
    List<T> save(String[] inputNames);
    void moveForward(T t, int value);

}
