package racingcar.method;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.model.RacingCar;
import racingcar.service.RacingCarService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CarMethodTest {

    public RacingCarService racingCarService = new RacingCarService();
    public List<RacingCar> racingCars = new ArrayList<>();

    @BeforeEach
    void initRacingCars() {
        List<String> names = Arrays.asList("a", "bb", "ccc");
        racingCars = names.stream()
                .map(RacingCar::new)
                .toList();
    }

    @Nested
    @DisplayName("입력 메서드 테스트")
    class InputTest {
        @Test
        @DisplayName("입력값을 받으면 RacingCar List가 반환되어야 한다")
        void initRacingCarMembers() {

            String input = "pobi,yunny,dani";
            List<RacingCar> racingCars = racingCarService.initRacingCarMembers(input);

            assertNotNull(racingCars);

            assertEquals(3, racingCars.size());

            assertEquals("pobi", racingCars.get(0).getUsername());
            assertEquals("yunny", racingCars.get(1).getUsername());
            assertEquals("dani", racingCars.get(2).getUsername());
        }

        @ParameterizedTest
        @CsvSource({"1000000000, 1_000_000_000", "1, 1", "2, 2", "3, 3"})
        @DisplayName("입력값을 받으면 시도 횟수인 정수형이 반환되어야 한다")
        void initNumberOfAttempts(String input, int value) {

            int number = racingCarService.initNumberOfAttempts(input);

            assertThat(number).isEqualTo(value);
        }
    }

    @Nested
    @DisplayName("메인 로직 테스트")
    class BusinessLogicTest {
        @Test
        @DisplayName("시도횟수 1번째 일때 각 자동차는 0칸 또는 1칸 전진한다")
        void movingForward() {

            List<RacingCar> movingCars = racingCarService.movingForward(racingCars);

            for (RacingCar racingCar : movingCars) {
                String currentLocation = racingCar.getCurrentLocation();
                assertThat(currentLocation.length()).isLessThanOrEqualTo(1);
            }
        }

        @Test
        @DisplayName("자동차 중 가장 멀리 간 차의 거리를 구한다")
        void findMaxDistance() {
            RacingCar racingCarA = racingCars.get(0);
            racingCarA.moveForwardOneSpace();

            int maxDistance = racingCarService.findMaxDistance(racingCars);

            assertEquals(maxDistance, 1);
        }

        @Test
        @DisplayName("자동차 중 우승자를 탐색한다")
        void findWinners() {
            RacingCar racingCarA = racingCars.get(0);
            racingCarA.moveForwardOneSpace();
            racingCarA.moveForwardOneSpace();

            List<String> winners = racingCarService.findWinners(racingCars, new ArrayList<>(), 2);

            assertEquals(winners.size(), 1);
            assertEquals(winners.get(0), "a");
        }
    }
}
