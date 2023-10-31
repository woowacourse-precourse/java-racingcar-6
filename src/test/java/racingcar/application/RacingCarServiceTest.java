package racingcar.application;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.GameResult;
import racingcar.domain.Navigator;

import java.util.List;

public class RacingCarServiceTest {

    private final Navigator testNavigator = new Navigator(() -> Randoms.pickNumberInRange(4, 9));

    @DisplayName("유효한 입력으로 자동차 경주 게임이 진행된다.")
    @Test
    void playRacingCarGameSuccessTest() {
        // given
        List<String> input = List.of("pobi", "crong", "honux");
        int numberOfRound = 5;

        // when
        RacingCarService racingService = new RacingCarService(testNavigator);
        GameResult gameResult = racingService.gameStart(input, numberOfRound);

        // then
        Assertions.assertThat(gameResult.roundHistory().get(numberOfRound - 1)
                .currentRound().getCurrentRound()).isEqualTo(numberOfRound);
        Assertions.assertThat(gameResult.roundHistory().get(numberOfRound - 1)
                .roundResult().results().size()).isEqualTo(input.size());
    }

    @DisplayName("잘못된 형식의 이름 입력으로 자동차 경주 게임이 진행되지 않는다.")
    @Test
    void playRacingCarGameFailTest() {
        // given
        List<String> input = List.of("bbbpobi", "crong", "honux");
        int numberOfRound = 3;

        // when
        RacingCarService racingService = new RacingCarService(testNavigator);

        // then
        Assertions.assertThatThrownBy(() -> racingService.gameStart(input, numberOfRound))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1자 이상, 5자 이하만 가능합니다.");
    }

    @DisplayName("잘못된 형식의 시도 횟수 입력으로 자동차 경주 게임이 진행되지 않는다.")
    @Test
    void playRacingCarGameFailTestByZero() {
        // given
        List<String> input = List.of("pobi", "crong", "honux");
        int numberOfRound = -1;

        // when
        RacingCarService racingService = new RacingCarService(testNavigator);

        // then
        Assertions.assertThatThrownBy(() -> racingService.gameStart(input, numberOfRound))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0 초과의 숫자만 입력 가능합니다.");
    }
}
