package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class RandomNumberTest {

    @DisplayName("RandomNumber 값이 특정 값 이상이지 테스트 : 값이 4 이상이라면 true, 미만이라면 false 반환.")
    @Test
    void isGreaterThan_4() {
        RandomNumber randomNumber1 = new RandomNumber(4);
        RandomNumber randomNumber2 = new RandomNumber(3);

        boolean expectedTrue = randomNumber1.isGreaterThan(4);
        boolean expectedFalse = randomNumber2.isGreaterThan(4);

        assertAll(
                () -> assertThat(expectedTrue).isTrue(),
                () -> assertThat(expectedFalse).isFalse()
        );
    }

    @DisplayName("RandomNumber 범위 0~9 테스트 : 0~9 사이의 숫자가 아니라면 IllegalArgumentException가 발생한다.")
    @Test
    void random_number_range_0_to_9() {
        assertThatThrownBy(() -> new RandomNumber(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("랜덤 생성 숫자는 0~9사이의 숫자여야 합니다.");
    }

    @DisplayName("create 생성 테스트 : RandomNumber 생성 시 특정 숫자를 부여할 수 있다.")
    @Test
    void create() {
        RandomNumber randomNumber = new RandomNumber(5);

        assertThat(randomNumber).usingRecursiveComparison()
                .comparingOnlyFields("number")
                .isEqualTo(new RandomNumber(5));
    }
}