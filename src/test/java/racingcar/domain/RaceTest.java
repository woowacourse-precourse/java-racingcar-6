package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RaceTest {
    @Test
    void raceInitialization() {
        Race race = new Race("pobi,woni,jun", 5);
        List<Car> cars = race.getCars();
        assertEquals(3, cars.size());
    }

    // 경주 시작 시 자동차가 실제로 전진하는지 테스트
    @Test
    void raceStart() {
        Race race = new Race("pobi,woni", 1) {
            @Override
            protected int generateRandomNumber() {
                return 5;
            }
        };
        race.start();
        assertTrue(race.getCars().get(0).getPosition() > 0);
        assertTrue(race.getCars().get(1).getPosition() > 0);
    }
}