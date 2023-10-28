package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("이름 도메인의 객체에")
class NameTest {

    @Nested
    @DisplayName("생성 요청시")
    class CreateValidation {

        @Test
        @DisplayName("생성시 정상적인 문자열을 받으면 예외를 던지지 않는가")
        void noException() {
            // given
            final String name = "a 가 1";
            // when
            // then
            assertThatNoException().isThrownBy(() -> new Name(name));
        }

        @Test
        @DisplayName("생성시 길이가 5를 초과하는 문자열을 받으면 예외를 던지는가")
        void longerThan5() {
            //given
            final String name = "abcdef";

            //when
            //then
            assertThatThrownBy(() -> new Name(name)).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("생성시 공백으로 시작하는 문자열을 받으면 예외를 던지는가")
        void startsWithBlank() {
            //given
            final String name = " abc";

            //when
            //then
            assertThatThrownBy(() -> new Name(name)).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("생성시 공백으로 끝나는 문자열을 받으면 예외를 던지는가")
        void endsWithBlank() {
            //given
            final String name = "abc ";

            //when
            //then
            assertThatThrownBy(() -> new Name(name)).isInstanceOf(IllegalArgumentException.class);
        }
    }
}
