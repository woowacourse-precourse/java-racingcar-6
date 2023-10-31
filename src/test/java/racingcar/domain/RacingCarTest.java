package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

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
}
