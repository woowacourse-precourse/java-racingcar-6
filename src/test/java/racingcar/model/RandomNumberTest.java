package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RandomNumberTest {

    @DisplayName("isGreaterThan() 테스트 : 값이크면 true 작으면 false를 반환한다.")
    @Test
    void isGreaterThan_특정값보다_큰지_확인() {
        RandomNumber randomNumber1 = new RandomNumber(4);
        RandomNumber randomNumber2 = new RandomNumber(3);

        boolean expectedTrue = randomNumber1.isGreaterThan(4);
        boolean expectedFalse = randomNumber2.isGreaterThan(4);

        assertAll(
                () -> assertThat(expectedTrue).isTrue(),
                () -> assertThat(expectedFalse).isFalse()
        );
    }

    @DisplayName("RandomNumber(number) 생성 예외 테스트 : 0~9 사이의 숫자가 아니라면 IllegalArgumentException가 발생한다.")
    @ParameterizedTest(name = "{0}는 0~9범위가 아니므로 예외가 발생한다.")
    @ValueSource(ints = {-1, 10, 999})
    void 예외발생_범위가_0_to_9_가_아니라면(int number) {
        assertThatThrownBy(() -> new RandomNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("랜덤 생성 숫자는 0~9사이의 숫자여야 합니다.");
    }

    @DisplayName("RandomNumber(number) 생성 예외 테스트 : 0~9 사이의 숫자라면 성공적으로 RandomNumber 객체가 생성된다.")
    @ParameterizedTest(name = "{0}는 0~9범위가 이므로 성공적으로 RandomNumber 객체가 생성된다.")
    @ValueSource(ints = {0, 5, 9})
    void 예외발생하지않음_0_to_9_라면(int number) {
        assertThatCode(() -> new RandomNumber(number))
                .doesNotThrowAnyException();
    }

    @DisplayName("RandomNumber(number) 생성 테스트 : RandomNumber 생성 시 특정 숫자를 부여할 수 있다.")
    @Test
    void create_생성자에_숫자가_주어ㅅ() {
        RandomNumber randomNumber = new RandomNumber(5);

        assertThat(randomNumber).usingRecursiveComparison()
                .comparingOnlyFields("number")
                .isEqualTo(new RandomNumber(5));
    }
}