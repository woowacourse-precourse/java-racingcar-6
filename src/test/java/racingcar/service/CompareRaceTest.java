package racingcar.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.RacingCar;

import java.util.List;

class CompareRaceTest {

    private CompareRace compareRace;

    @BeforeEach
    void setUp() {
        compareRace = new CompareRace();
    }

    @DisplayName("자동차 이름과 이동 횟수를 입력받아 4 이상일때만 전진하는지")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7 ,8, 9})
    void moveCarsTest(Integer movement) {
        // given
        String inputCarName = "pobi,woni";
        List<RacingCar> racingCars = RacingCar.fromInputCarName(inputCarName);

        // when
        List<RacingCar> resultMoveCars = compareRace.moveCars(racingCars, movement);

        // then
        for (RacingCar racingCar : resultMoveCars) {
            assertTrue(racingCar.isMoveCountLessThanOrEqualTo(movement));
        }
    }
}