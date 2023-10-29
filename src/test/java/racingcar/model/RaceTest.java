package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class RaceTest {

    @DisplayName("race 회수 유효성 검사 테스트")
    @Test
    void testValidateNumberOfRace() {
        assertDoesNotThrow(() -> new Race(5));
    }

    @DisplayName("race 회수 유효성 검사 exception 테스트")
    @Test
    void testValidateNumberOfRaceThrow() {
        assertThrows(IllegalArgumentException.class, () -> new Race(101));
    }

    @DisplayName("한 경기 진행 기능")
    @Test
    void testRunSingleRace() {
        Car car = new Car("pobi");
        Race race = new Race(1);

        race.runSingleRace(car);

        assertTrue(car.getPosition() == 0 || car.getPosition() == 1);
    }

}
