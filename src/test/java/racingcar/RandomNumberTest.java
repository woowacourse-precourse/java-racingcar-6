package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RandomNumberTest {
    private RandomNumber randomNumber;

    @BeforeEach
    void setUp() {
        randomNumber = new RandomNumber();
    }

    @Test
    void generate_메서드로_범위내의_임의의_수_생성() {
        int result = randomNumber.generate();

        assertThat(result).isBetween(0, 9);
    }

    @Test
    void judge_메서드로_기준점_이상의_수_이면_참_반환() {
        boolean result = randomNumber.judge(7);

        assertThat(result).isTrue();
    }

    @Test
    void judge_메서드에_generate_메서드로_값_입력시_적합한_결과_반환() {
        int input = randomNumber.generate();
        boolean result = randomNumber.judge(input);

        if (input < 4) {
            assertThat(result).isFalse();
        }
        if (input >= 4) {
            assertThat(result).isTrue();
        }
    }
}