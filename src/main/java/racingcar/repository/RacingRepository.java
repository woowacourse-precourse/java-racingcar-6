package racingcar.repository;

import java.util.List;

public interface RacingRepository {
    void saveRaceResult(List<Car> cars);

    List<List<Car>> getRaceResults();

    List<Car> getWinners();

    void create(Car car);

    List<Car> findAll();
}
