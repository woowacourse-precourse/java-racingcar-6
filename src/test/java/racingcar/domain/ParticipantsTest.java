package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.strategy.FakeRacingCarMoveStrategy;


@DisplayName("[도메인] 참가자 목록에서 ")
class ParticipantsTest {

    @Test
    void 우승자를_조회_할_수_있다() {

        final var participants = Participants.of(List.of("테스트1", "테스트2", "테스트3"));
        final var racingCarMoveStrategy = new FakeRacingCarMoveStrategy(true, false, false);

        final var winners = participants.moveAll(racingCarMoveStrategy)
                .collectWinnerNames();

        assertThat(winners).isEqualTo(List.of("테스트1"));
    }

    @Test
    void 우승자가_여러명일_수_있다() {

        final var participants = Participants.of(List.of("테스트1", "테스트2", "테스트3"));
        final var racingCarMoveStrategy = new FakeRacingCarMoveStrategy(true, true, false);

        final var winners = participants.moveAll(racingCarMoveStrategy)
                .collectWinnerNames();

        assertThat(winners).isEqualTo(List.of("테스트1", "테스트2"));
    }


}