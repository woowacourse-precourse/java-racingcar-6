package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.constant.Constant.ENTER;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.RacingCarDto;

class ViewResolverTest {

    @Test
    @DisplayName("싱글 게임 결과로 게임 결과를 만든다.")
    void resolveSingleGameResult() {
        // given
        RacingCarDto k5 = new RacingCarDto("k5", 1);
        RacingCarDto k3 = new RacingCarDto("k3", 0);
        RacingCarDto sm3 = new RacingCarDto("sm3", 2);
        List<RacingCarDto> racingCarDtos = List.of(k5, k3, sm3);
        ViewResolver viewResolver = new ViewResolver();

        // when
        String result = viewResolver.singleGameResult(racingCarDtos);

        // then
        assertThat(result).isEqualTo(
                "k5 : -" + ENTER + "k3 : " + ENTER +  "sm3 : --" + ENTER
        );
    }

    @Test
    @DisplayName("게임 결과로 최종 우승자 목록을 만든다.")
    void resolveWinner() {
        // given
        RacingCarDto k5 = new RacingCarDto("k5", 3);
        RacingCarDto k3 = new RacingCarDto("k3", 5);
        RacingCarDto sm3 = new RacingCarDto("sm3", 5);
        List<RacingCarDto> racingCarDtos = List.of(k5, k3, sm3);
        ViewResolver viewResolver = new ViewResolver();

        // when
        List<String> result = viewResolver.winners(racingCarDtos);

        // then
        assertThat(result).isEqualTo(List.of("k3", "sm3"));
    }

}