package racingcar.domain.generator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class NumberGeneratorTest {
    @Test
    public void createBetween0and9_0부터9사이의_숫자_생성(){
        NumberGenerator numberGenerator = new NumberGenerator();
        int result=numberGenerator.createBetween0and9();

        assertThat(result).isBetween(0,9);
    }
}