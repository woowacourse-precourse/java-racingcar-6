package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.output.ResultOfGameDto;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RacingCarsTest {
    private RacingCars racingCars;

    @Test
    @DisplayName("우승자가 1명 존재한다.")
    void hasOneRacingWinner() {
        // given
        RacingCar racingCar1 = new RacingCar("pobi");
        RacingCar racingCar2 = new RacingCar("jun");
        racingCars = RacingCars.from(List.of(racingCar1, racingCar2));
        // when
        racingCar1.advance();
        ResultOfGameDto dto = racingCars.getWinners();
        // then
        assertEquals(1, dto.winnerName().size());
    }

    @Test
    @DisplayName("우승자가 2명 존재한다.")
    void hasTwoRacingWinner() {
        // given
        RacingCar racingCar1 = new RacingCar("pobi");
        RacingCar racingCar2 = new RacingCar("jun");
        racingCars = RacingCars.from(List.of(racingCar1, racingCar2));
        // when
        racingCar1.advance();
        racingCar2.advance();
        ResultOfGameDto dto = racingCars.getWinners();
        // then
        assertEquals(2, dto.winnerName().size());
    }
}
