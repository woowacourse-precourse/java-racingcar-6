package racingcar.service;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCars;

public class RacingCarServiceTest {

    RacingCarService racingCarService;

    @BeforeEach
    void setUp() {
        this.racingCarService = new RacingCarService();
    }

    @DisplayName("RacingCars 객체를 생성한다. - 성공")
    @Test
    void createRacingCarsTest() {
        // given
        List<String> carNames = Arrays.asList("pobi", "woni", "jun");

        // when
        RacingCars racingCars = racingCarService.createRacingCars(carNames);

        // then
        assertAll(
            () -> assertEquals(racingCars.getRacingCars().size(), 3),
            () -> assertEquals(racingCars.getRacingCars().get(0).getName(), "pobi"),
            () -> assertEquals(racingCars.getRacingCars().get(0).getPosition(), 0)
        );
    }

}
