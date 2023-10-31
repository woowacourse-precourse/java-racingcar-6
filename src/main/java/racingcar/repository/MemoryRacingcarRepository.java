package racingcar.repository;

import java.util.*;

import racingcar.domain.Racingcar;

public class MemoryRacingcarRepository implements RacingcarRepository {

    private Map<String, Racingcar> carStore = new HashMap<>();

    // 데이터 삽입
    @Override
    public Racingcar save(String name) {
        Racingcar racingCar = new Racingcar(name);
        carStore.put(name, racingCar);

        return racingCar;
    }

    // 데이터 검색
    @Override
    public Racingcar findByName(String name) {
        return carStore.get(name);
    }

    // 데이터 전체 반환
    @Override
    public ArrayList<Racingcar> findAll() {
        return new ArrayList<>(carStore.values());
    }

    // 데이터 초기화
    public void clear() {
        carStore.clear();
    }
}
