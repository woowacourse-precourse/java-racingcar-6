package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.UserCarNameDto;

public class RacingGameTest {

    @DisplayName("레이싱 게임을 생성한다.")
    @Test
    void createTest() {
        Cars cars = Cars.from(new UserCarNameDto(List.of("pobi", "woni", "jun")), new FixedCarEngine(true));
        AttemptCounts attemptCounts = AttemptCounts.from("1");
        assertThatCode(() -> RacingGame.of(cars, attemptCounts))
                .doesNotThrowAnyException();
    }

    @DisplayName("레이싱 경기를 한 회 진행하고 해당 회의 결과를 반환한다.")
    @Test
    void playTest() {
        Cars cars = Cars.from(new UserCarNameDto(List.of("pobi", "woni", "jun")), new FixedCarEngine(true));
        AttemptCounts attemptCounts = AttemptCounts.from("1");
        RacingGame racingGame = RacingGame.of(cars, attemptCounts);
        assertThat(racingGame.isRemainAttemptCounts()).isTrue(); // 시도 횟수 1 남아있으므로 true.
        RacingRoundResult racingRoundResult = racingGame.play();
        assertThat(racingRoundResult.getWinners()).isEqualTo(
                List.of("pobi", "woni", "jun")); // FixedCarEngine 자동차는 무조건 1칸 진행시키기 때문에 공동우승.
        assertThat(racingGame.isRemainAttemptCounts()).isFalse(); // 레이스를 진행했으므로 잔여 시도 횟수 0.
    }
}
