package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static racingcar.view.exception.ExceptionMessage.DUPLICATE_NAME_EXCEPTION;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.util.List;

public class NamesTest {

    @Test
    @DisplayName("쉼표를 기준으로 이름이 분할된다.")
    void playNamesSizeTest() {
        // given & when
        Names names = Names.from("john,bob,alice");
        List<Name> playNames = names.getNames();

        // then
        assertThat(playNames.size()).isEqualTo(3);
    }

    @Nested
    @DisplayName("이름 독립/중복 테스트")
    class DuplicateNamesTest {

        @Test
        @DisplayName("이름이 모두 독립적이면 정상 생성된다.")
        void splitNamesTest() {
            // when & then
            assertDoesNotThrow(() -> Names.from("john,bob,alice"));
        }

        @Test
        @DisplayName("같은 이름이 발견되면 예외가 발생한다.")
        void duplicateNamesExceptionTest() {
            // when & then
            assertThatThrownBy(() -> Names.from("john,john,bob")).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(DUPLICATE_NAME_EXCEPTION.getMessage());
        }
    }
}
