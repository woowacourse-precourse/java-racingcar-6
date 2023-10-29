package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.model.constants.Rule.RANDOM_MAX_SIZE;
import static racingcar.model.constants.Rule.RANDOM_MIN_SIZE;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GeneratorTest {
    private int randomNumber;

    @BeforeEach
    void setUp() {
        randomNumber = Generator.generateRandomNumber();
    }

    @Test
    @DisplayName("입램덤 숫자 생성을 테스트 합니다.")
    void 랜덤_숫자_생성_검사() {
        assertThat(randomNumber).isNotNull();
    }

    @Test
    @DisplayName("랜덤 숫자가 범위 안에서 생성되는지 테스트 합니다.")
    void 랜덤_숫자_범위_검사() {
        assertThat(randomNumber).isBetween(RANDOM_MIN_SIZE.getValue(), RANDOM_MAX_SIZE.getValue());
    }
}