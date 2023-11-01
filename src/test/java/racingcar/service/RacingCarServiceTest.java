package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Cars;
import racingcar.model.MovingCondition;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.mock;

@DisplayName("레이싱카 서비스에 대해")
class RacingCarServiceTest {

    private final MovingCondition movingCondition = mock(MovingCondition.class);
    private final RacingCarService racingCarService = new RacingCarService(movingCondition);

    @Test
    @DisplayName("최종 우승자를 구할 수 있다.")
    void get_final_winners() {
        //given
        Cars cars = new Cars("pobi,woni,jun");
        given(movingCondition.canMove()).willReturn(true);

        //when
        racingCarService.startRacing(cars);
        String finalWinners = cars.getFinalWinners();

        //then
        assertThat(finalWinners).containsAnyOf("pobi", "woni", "jun");
    }
}
