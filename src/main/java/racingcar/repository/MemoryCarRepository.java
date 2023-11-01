package racingcar.repository;

import racingcar.domain.racing.car.Car;

/**
 * CarRepository를 구현하고 MemoryRepository를 확장해 내장 Map 저장소를 사용합니다.
 */
public class MemoryCarRepository extends MemoryRepository<Car> implements CarRepository {

}
