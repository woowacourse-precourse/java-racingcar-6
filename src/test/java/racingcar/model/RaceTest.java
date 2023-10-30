package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class RaceTest {

    Generator generator = new Generator();

    @DisplayName("race 회수 유효성 검사 테스트")
    @Test
    void testValidateNumberOfRace() {
        assertDoesNotThrow(() -> Race.from(5, generator));
    }

    @DisplayName("race 회수 유효성 검사 exception 테스트")
    @Test
    void testValidateNumberOfRaceThrow() {
        assertThrows(IllegalArgumentException.class, () -> Race.from(101, generator));
    }

    @DisplayName("한 경기 진행 기능")
    @Test
    void testRunSingleRace() {
        Car car = Car.from("pobi");
        Race race = Race.from(1, generator);

        race.runSingleRace(List.of(car));

        assertTrue(car.getPosition() == 0 || car.getPosition() == 1);
    }

}
