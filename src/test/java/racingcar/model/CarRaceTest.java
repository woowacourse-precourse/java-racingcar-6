package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarRaceTest {
    private CarRace carRace;
    private List<RacingCar> racingCars;

    @BeforeEach
    public void setUp() {
        racingCars = new ArrayList<>();
        racingCars.add(new RacingCar("car1"));
        racingCars.add(new RacingCar("car2"));
        racingCars.add(new RacingCar("car3"));

        RandomDistanceGenerator testGenerator = new RandomDistanceGenerator() {
            @Override
            public int moveDistance() {
                return 1;
            }
        };

        carRace = new CarRace(racingCars, 5, testGenerator);
    }

    @Test
    @DisplayName("최대 천 가져오기 검증")
    public void testGetTurn() {
        int carRaceTurn = carRace.getTargetTurn();
        assertEquals(5, carRaceTurn);
    }

    @Test
    @DisplayName("레이스 이동 검증")
    public void testRace() {
        List<RacingCar> result = carRace.race();
        for (RacingCar car : result) {
            assertEquals(1, car.getDistance());
        }
    }


    @Test
    @DisplayName("우승자 목록 검증")
    public void testGetWinners() {
        carRace.race();
        List<RacingCar> winners = carRace.getWinners();

        assertTrue(winners.contains(racingCars.get(0)));
        assertTrue(winners.contains(racingCars.get(1)));
        assertTrue(winners.contains(racingCars.get(2)));

        for (RacingCar winner : winners) {
            assertEquals(1, winner.getDistance());
        }
    }
}