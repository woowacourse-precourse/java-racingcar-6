package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Race;

import static org.junit.jupiter.api.Assertions.*;

public class RaceTest {

    private Race race;
    private Car car1;
    private Car car2;

    @BeforeEach
    public void setUp() {
        race = new Race();
        car1 = new Car("Car1");
        car2 = new Car("Car2");
        race.addCar(car1);
        race.addCar(car2);
    }

    @Test
    @DisplayName("레이스에 참여한 자동차가 올바르게 추가되었는지 확인한다.")
    public void givenRace_whenAddCar_thenSuccess() {
        assertNotNull(race.getMovingDistance());
        assertEquals(2, race.getMovingDistance().size());
        assertTrue(race.getMovingDistance().containsKey(car1));
        assertTrue(race.getMovingDistance().containsKey(car2));
        assertEquals(0, race.getMovingDistance().get(car1));
        assertEquals(0, race.getMovingDistance().get(car2));
    }

    @Test
    @DisplayName("결과 반환시, 올바른 형식으로 반환되는지 확인하다.")
    public void givenRaceRun_whenRequestResult_thenisCorrect() {
        race.run();
        String result = race.toResult();
        assertTrue(result.contains("Car1 :"));
        assertTrue(result.contains("Car2 :"));
    }

    @Test
    @DisplayName("우승자가 올바르게 반환되는지 확인한다.")
    public void givenRaceRun_whenGetwinnerThenisCorrect() {
        race.run();
        String winner = race.getWinner();
        race.getMovingDistance().forEach((car, distance) -> {
            if (distance == 1) {
                assertTrue(winner.contains(car.name()));
            }
        });
    }
}
