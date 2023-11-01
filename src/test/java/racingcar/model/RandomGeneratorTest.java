package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class RandomGeneratorTest {
    private RandomGenerator generator;

    @BeforeEach
    void setUp() {
        generator = new RandomGenerator();
    }

    @Test
    void getNumbers_전달한_수만큼_랜덤값을_가진_리스트를_반환() {
        //given
        // setUp() 코드 실행

        //when
        List<Integer> randomNumbers = generator.getNumbers(10);

        //then
        assertThat(randomNumbers.size()).isEqualTo(10);
    }

    @Test
    void getNumbers_0에서_9까지의_숫자만_생성해_리스트에_저장() {
        //given
        // setUp() 코드 실행

        //when
        List<Integer> randomNumbers = generator.getNumbers(100);

        //then
        for (int randomNumber : randomNumbers) {
            assertThat(randomNumber).isGreaterThanOrEqualTo(0);
            assertThat(randomNumber).isLessThanOrEqualTo(9);
        }
    }
}