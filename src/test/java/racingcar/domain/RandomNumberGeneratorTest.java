package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    @Test
    public void 난수_생성(){
        int min = 0;
        int max = 9;
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        Integer number=randomNumberGenerator.generate();

        assertThat(inRange(min,max,number)).isTrue();
    }

    private static boolean inRange(int min, int max, Integer number) {
        return min <= number && number <= max;
    }

}
