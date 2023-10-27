package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RacingCarGameServiceTest {

    @ParameterizedTest
    @CsvSource({"3,false", "4,true", "5,true"})
    @DisplayName("{$랜덤 숫자}, {$전진 결과} : 3 이하는 정지상태를 유지하고 4 이상은 전진한다.")
    public void should_MovingForward_When_FourOrMore(int randomNumber, boolean expected) {
        RacingCarGameService racingCarGameService = new RacingCarGameService();

        boolean actual = racingCarGameService.isMovingForward(randomNumber);

        assertThat(actual).isEqualTo(expected);
    }
}
