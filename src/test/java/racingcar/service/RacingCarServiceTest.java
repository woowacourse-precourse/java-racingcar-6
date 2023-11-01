package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import jdk.jfr.Name;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarGroup;

class RacingCarServiceTest {

    private final RacingCarService racingCarService = new RacingCarService();

    @Test
    @Name("자동차 이름을 콤마(,)로 구분하여 입력받아 자동차 그룹을 생성하는지 확인")
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
    @Name("라운드 숫자를 입력받아 정수형으로 반환하는지 확인")
    void getRoundNumber() {
        // given
        String round = "5";
        // when
        int roundNumber = racingCarService.getRoundNumber(round);
        // then
        assertEquals(roundNumber, 5);
    }

    @Test
    @Name("우승자들을 반환하는지 확인")
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