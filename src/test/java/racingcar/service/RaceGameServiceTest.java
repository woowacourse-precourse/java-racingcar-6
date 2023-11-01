package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import racingcar.OutputTestSupport;
import racingcar.dto.RaceGameInfoDto;
import racingcar.domain.car.Car;
import racingcar.domain.car.RaceCars;
import racingcar.util.Randoms;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RaceGameServiceTest extends OutputTestSupport {

    private RaceGameService raceGameService = new RaceGameService();

    @Test
    @DisplayName("게임 진행을 Mock을 이용해서 테스트할 수 있다.")
    public void RaceGameServiceTest() {
        // given
        String result = "\n실행 결과\n" +
                        "haen : -\n\n" +
                        "haen : --\n\n";

        RaceCars raceCars = new RaceCars(List.of(new Car("haen")));
        RaceGameInfoDto raceGameInfoDto = new RaceGameInfoDto(raceCars, 2);

        try (final MockedStatic<Randoms> randoms = Mockito.mockStatic(Randoms.class)) {
            BDDMockito.given(Randoms.getNumber()).willReturn(4);
            //when
            raceGameService.run(raceGameInfoDto);
        }
        //then
        assertThat(getOutput()).isEqualTo(result);
    }

}