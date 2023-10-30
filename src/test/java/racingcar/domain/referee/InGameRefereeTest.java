package racingcar.domain.referee;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.domain.generator.NumberGenerator;

class InGameRefereeTest {
    @Test
    public void createBetween0and9_0부터9사이의_숫자_생성(){
        NumberGenerator numberGenerator = new NumberGenerator();
        int result=numberGenerator.createBetween0and9();

        assertThat(result).isBetween(0,9);
    }
}