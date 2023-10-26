package racingcar.domain.generator;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RandomNumberGeneratorTest {

    @DisplayName("범위에 맞는 값이 나오는지 테스트")
    @ParameterizedTest
    @CsvSource(value = {"0:3", "1:7", "2:9"}, delimiter = ':')
    void 숫자_생성_테스트(int startInclusion, int endInclusion) {

        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        // given
        int randomNumber = randomNumberGenerator.createInRange(startInclusion, endInclusion);

        //when
        boolean outOfRange = randomNumber < startInclusion || randomNumber > endInclusion;

        // then
        Assertions.assertThat(outOfRange).isFalse();

    }

}