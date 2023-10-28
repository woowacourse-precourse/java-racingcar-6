package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class RandomNumberTest {

    @DisplayName("create 생성 테스트 : RandomNumber 생성 시 특정 숫자를 부여할 수 있다.")
    @Test
    void create() {
        RandomNumber randomNumber = new RandomNumber(5);

        assertThat(randomNumber).usingRecursiveComparison()
                .comparingOnlyFields("number")
                .isEqualTo(new RandomNumber(5));
    }
}