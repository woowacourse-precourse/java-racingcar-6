package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.exception.ErrorMessage.CAR_NAME_LENGTH_OVER_FIVE_EXCEPTION;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.condition.MoveCondition;

public class RacingCarTest {

    @ParameterizedTest
    @DisplayName("레이싱 카 이름이 주어지면, 이름이 5자리 이하인지 확인하고 생성한다.")
    @ValueSource(strings = {"suz", "&(&(", "chan"})
    void createRacingCarWithCarNameLessThanFive(String given) {
        // given
        MoveCondition moveCondition = new MoveCondition();

        // when
        RacingCar racingCar = new RacingCar(given, moveCondition);

        // then
        assertThat(racingCar).isEqualTo(new RacingCar(given, moveCondition));
    }

    @ParameterizedTest
    @DisplayName("자동차 이름이 5자라 넘으면 예외가 발생한다.")
    @ValueSource(strings = {"suzhan", "&(&(12", "chanlee"})
    void createRacingCarError(String given) {
        // given
        MoveCondition moveCondition = new MoveCondition();

        // when //then
        assertThatThrownBy(() -> new RacingCar(given, moveCondition))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_LENGTH_OVER_FIVE_EXCEPTION);
    }
}
