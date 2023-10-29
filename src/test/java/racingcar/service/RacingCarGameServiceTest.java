package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RacingCarGameServiceTest {

    @ParameterizedTest(name = "[테스트 케이스 {index}] 랜덤 숫자 = {0}, 전진 결과 = {1}")
    @CsvSource({"3,false", "4,true", "5,true"})
    @DisplayName("4이상은 전진하고, 3이하는 정지상태를 유지한다.")
    public void should_MovingForward_When_FourOrMore(int randomNumber, boolean expected) {
        RacingCarGameService racingCarGameService = new RacingCarGameService();

        boolean actual = racingCarGameService.isMovingForward(randomNumber);

        assertThat(actual).isEqualTo(expected);
    }
}
