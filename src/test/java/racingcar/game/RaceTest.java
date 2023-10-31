package racingcar.game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Name;
import racingcar.strategy.AlwaysMoveStrategy;

class RaceTest {
    private Race race;
    private Cars cars;

    @BeforeEach
    void setup() {
        // 테스트 전에 초기화 코드를 실행
        List<Car> carList = Arrays.asList(
                Car.of(Name.from("Car1"), AlwaysMoveStrategy.getInstance()),
                Car.of(Name.from("Car2"), AlwaysMoveStrategy.getInstance()),
                Car.of(Name.from("Car3"), AlwaysMoveStrategy.getInstance())
        );

        cars = Cars.from(carList);
        race = Race.of(cars, 1);
    }

    @Test
    void 레이스_실행_자동차_움직임_확인() {
        // When: performRaceStep 메서드를 호출
        race.performRaceStep();

        // Then: 모든 차량이 이동했는지 확인
        for (Car car : race.getCars()) {
            assertEquals(1, car.getStep());
        }
    }

    @Test
    void 승자_결정_확인() {
        // When
        race.performRaceStep();
        List<Car> winners = race.determineWinners();

        // Then
        assertEquals(3, winners.size());
    }

    @Test
    void 남은_레이스_존재_확인() {
        // Then
        assertTrue(race.hasRemainingRaces());
    }

    @Test
    void 레이스_0_초기화_예외_처리() {
        // Then
        assertThrows(IllegalArgumentException.class, () -> Race.of(cars, 0));
    }

    @Test
    void 레이스_1_초기화_예외_처리() {
        // Then
        assertThrows(IllegalArgumentException.class, () -> Race.of(cars, -1));
    }
}