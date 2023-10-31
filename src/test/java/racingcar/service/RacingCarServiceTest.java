package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import racingcar.domain.CarGroup;

class RacingCarServiceTest {

    private final RacingCarService racingCarService = new RacingCarService();

    @Test
    void createCarGroup() {
        //given
        String carNames = "pobi,crong,honux";
        String delimiter = ",";
        //when
        CarGroup carGroup = racingCarService.createCarGroup(carNames, delimiter);
        //then
        assertEquals(carGroup.getCars().size(), 3);
        assertThat(carGroup.getCars().get(0).getName()).isEqualTo("pobi");
        assertThat(carGroup.getCars().get(1).getName()).isEqualTo("crong");
        assertThat(carGroup.getCars().get(2).getPosition()).isEqualTo(0);
    }

    @Test
    void getRoundNumber() {
        // given
        String round = "5";
        // when
        int roundNumber = racingCarService.getRoundNumber(round);
        // then
        assertEquals(roundNumber, 5);
    }

    @Test
    void moveCarGroup() {
        // given
        CarGroup carGroup = racingCarService.createCarGroup("test", ",");
        // when
        boolean isMoved = racingCarService.moveCarGroup(carGroup);
        // then
        assertTrue(isMoved);
    }

    @Test
    void getWinners() {
    }
}