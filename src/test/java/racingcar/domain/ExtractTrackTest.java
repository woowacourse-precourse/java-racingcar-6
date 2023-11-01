package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.DomainExceptionCode;


@DisplayName("[도메인] 잔여 트랙 수를 ")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ExtractTrackTest {

    @Nested
    @DisplayName(" 생성할 때")
    class CreateTest {

        @ParameterizedTest
        @ValueSource(ints = {-1, -2, -3})
        void _0보다_작을_수_없습니다(int count) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new ExtractTrack(count))
                    .withMessageContaining(DomainExceptionCode.EXTRACT_TRACK_MUST_BE_GRATER_THAN_ZERO.getMessage());
        }
    }

    @Nested
    @DisplayName(" 동작시킬 때")
    class ActionTest {

        @Test
        void _트랙_카운트를_소비할_때_잔여량이_0보다_작은_경우_오류가_발생합니다b() {

            final var extractTrack = new ExtractTrack(3);
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> extractTrack.consumerCount()
                            .consumerCount()
                            .consumerCount()
                            .consumerCount()
                    ).withMessageContaining(DomainExceptionCode.EXTRACT_TRACK_MUST_BE_GRATER_THAN_ZERO.getMessage());
        }

        @Test
        void _트랙_카운트가_정상적으로_1_차감됩니다() {
            final var extractTrack = new ExtractTrack(5);
            assertAll(
                    () -> assertThat(extractTrack.consumerCount().value()).isEqualTo(4),
                    () -> assertThat(extractTrack.consumerCount()
                            .consumerCount()
                            .value())
                            .isEqualTo(3)
            );
        }

        @Test
        void _트랙_카운트가_모두_소비되면_완료된다() {
            final var extractTrack = new ExtractTrack(2)
                    .consumerCount()
                    .consumerCount();

            assertThat(extractTrack.isCompleted()).isTrue();
        }

        @Test
        void _트랙_카운트가_모두_소비되지_않으면_완료되지_않는다() {
            final var extractTrack = new ExtractTrack(2)
                    .consumerCount();

            assertThat(extractTrack.isCompleted()).isFalse();
        }
    }
}