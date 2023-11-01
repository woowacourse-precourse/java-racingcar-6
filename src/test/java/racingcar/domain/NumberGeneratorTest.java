package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberGeneratorTest{

    private NumberGenerator generator;

    @BeforeEach
    void init(){
        generator = new NumberGenerator();
    }

    @Test
    @DisplayName("0-9 사이에서 무작위 값을 구한다.")
    void _0_9_사이에서_무작위_값_구하기(){
        //when
        int number = generator.createRandomNumber();

        //then
        assertThat(number).isBetween(0, 9);

    }

}
