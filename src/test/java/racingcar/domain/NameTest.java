package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.exception.RacingCarException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static racingcar.exception.ErrorMessage.*;
import static racingcar.fixture.NameFixture.*;

@DisplayName("[Name Test] - Domain Layer")
class NameTest {

    @Nested
    @DisplayName("[create Test - Constructor Static Factory Method]")
    class createTest {

        @Test
        @DisplayName("[Success] 차량 이름이 조건에 부합해 차량 생성에 성공합니다.")
        void Given_ValidName_When_Create_Then_Success() {
            //given
            String validName = VALID_KOREAN.getName();

            //when
            Name name = Name.create(validName);

            //then
            assertThat(name.getName()).isEqualTo(validName);
        }

        @Test
        @DisplayName("[Exception] 차량 이름이 제한 길이을 초과할 경우 예외를 던집니다.")
        void Given_TooLongName_When_Create_Then_ThrowException() {
            //given
            String tooLong = INVALID_TOO_LONG.getName();

            //when && then
            assertThatThrownBy(() -> Name.create(tooLong))
                    .isInstanceOf(RacingCarException.class)
                    .hasMessageContaining(TOO_LONG_NAME.getMessage());
        }

        @Test
        @DisplayName("[Exception] 차량 이름이 비어있다면 예외를 던집니다.")
        void Given_EmptyName_When_Create_Then_ThrowException() {
            //given
            String emptyName = INVALID_EMPTY.getName();

            //when && then
            assertThatThrownBy(() -> Name.create(emptyName))
                    .isInstanceOf(RacingCarException.class)
                    .hasMessageContaining(EMPTY.getMessage());
        }

        @Test
        @DisplayName("[Exception] 차량 이름에 WhiteSpace가 포함되어 있을 경우 예외를 던집니다.")
        void Given_NameContainWhitespace_When_Create_Then_ThrowException() {
            //given
            String containSpace = INVALID_CONTAIN_WHITE_SPACE.getName();
            String containTab = INVALID_CONTAIN_TAB.getName();

            //when && then
            assertAll(
                    () -> assertThatThrownBy(
                            () -> Name.create(containSpace))
                            .isInstanceOf(RacingCarException.class)
                            .hasMessageContaining(CONTAIN_IMPROPER_LETTER.getMessage()
                            ),

                    () -> assertThatThrownBy(
                            () -> Name.create(containTab))
                            .isInstanceOf(RacingCarException.class)
                            .hasMessageContaining(CONTAIN_IMPROPER_LETTER.getMessage()
                            )
            );
        }
    }
}
