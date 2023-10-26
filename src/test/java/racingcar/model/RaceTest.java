package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RaceTest {
    private List<Car> cars;
    private Race race;

    @BeforeEach
    public void setUp() {
        cars = Arrays.asList(new Car("pobi"), new Car("woni"), new Car("jun"));
        race = new Race(cars);
    }

    @Test
    @DisplayName("Race 객체 생성 후, Car 객체 리스트와 동일한지 검증")
    public void testConstructor() {
        assertNotNull(race.getCars());
        assertEquals(cars, race.getCars());
    }

    @Test
    @DisplayName("run 메서드 동작 확인")
    public void testRun() {
        assertDoesNotThrow(() -> race.run(), "예외처리 요류가 발생하면 안됩니다.");
    }
}