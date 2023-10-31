package racingcar.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.domain.CarGroup;

class RacingCarServiceTest {

    private final RacingCarService racingCarService = new RacingCarService();

    @Test
    void createCarGroup() {
        //given
        String carNames = "test1,test2,test3";
        String delimiter = ",";
        //when
        CarGroup carGroup = racingCarService.createCarGroup(carNames, delimiter);
        //then
        assertEquals(carGroup.getCars().size(), 3);
        assertThat(carGroup.getCars().get(0).getName()).isEqualTo("test1");
        assertThat(carGroup.getCars().get(1).getName()).isEqualTo("test2");
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
    void getWinners() {
        // given
        CarGroup carGroup = racingCarService.createCarGroup("test1,test2", ",");
        carGroup.getCars().get(0).move();
        // when
        List<String> winners = racingCarService.getWinners(carGroup);
        // then
        assertEquals(winners.size(), 1);
        assertEquals(winners.get(0), "test1");
    }

}