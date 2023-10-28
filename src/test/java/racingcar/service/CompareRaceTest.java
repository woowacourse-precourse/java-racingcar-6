package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.RacingCar;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class CompareRaceTest {

    private CompareRace compareRace;

    @BeforeEach
    void setUp() {
        compareRace = new CompareRace();
    }

    @DisplayName("자동차가 랜덤한 숫자 중 4 이상일때만 전진하는지")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7 ,8, 9})
    void moveCarsTest(Integer randomNumber) {
        // given
        String inputCarNames = "pobi,woni";
        List<RacingCar> racingCars = RacingCar.fromInputCarName(inputCarNames);

        // when
        compareRace.moveCars(racingCars);

        // then
        for (RacingCar racingCar : racingCars) {
            assertTrue(racingCar.isMoveCountLessThanOrEqualTo(randomNumber));
        }
    }

    @DisplayName("이동횟수가 가장 높은 우승차를 찾아내는지")
    @Test
    void findWinnerCars() {
        // given
        String inputCarNames = "pobi,woni,bemo,roro";
        Integer[] carMovement = {2, 3, 1, 3};
        List<RacingCar> racingCars = RacingCar.fromInputCarName(inputCarNames);

        IntStream.range(0, racingCars.size()).forEach(i -> {
            for (int j = 0; j < carMovement[i]; j++) {
                racingCars.get(i).forward();
            }
        });

        // when
        List<RacingCar> winnerCars = compareRace.findWinnerCars(racingCars);

        // then
        assertEquals(2, winnerCars.size());
        assertEquals("woni", winnerCars.get(0).printCarName());
        assertEquals("roro", winnerCars.get(1).printCarName());
    }
}