package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyInt;
import static racingcar.constant.InputError.BLANK_CAR_NAME;
import static racingcar.constant.InputError.EXCEEDED_LIMIT_CAR_LENGTH;
import static racingcar.constant.RaceConfig.INITIAL_CAR_POSITION;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarsTest {

    @DisplayName("경주 자동차 생성시 입력값이 쉼표를 기준으로 분리된다.")
    @Test
    void success_Multiple_Input_With_Delimiter() {
        // given
        String input = "apple,bear,cake";
        List<String> expected = List.of(input.split(","));

        // when
        RacingCars racingCars = RacingCars.createRacingCars(input);

        // then
        assertThat(racingCars).hasFieldOrPropertyWithValue("names", expected);
    }

    @DisplayName("경주 자동차 생성시 입력값 내 다른 구분자는 분리되지 않는다.")
    @Test
    void success_Multiple_Input_With_Two_Delimiter() {
        // given
        String input = "a.b.c,d.e.f";
        List<String> expected = List.of(input.split(","));

        // when
        RacingCars racingCars = RacingCars.createRacingCars(input);

        // then
        assertThat(racingCars).hasFieldOrPropertyWithValue("names", expected);
    }

    @DisplayName("경주 자동차로 자동차의 이름과 위치의 초기값이 담긴 Map을 생성한다.")
    @Test
    void success_createInitPosition() {
        // given
        String input = "apple,bear,cake";
        List<String> names = List.of(input.split(","));
        RacingCars racingCars = RacingCars.createRacingCars(input);

        // when
        Map<String, Integer> result = racingCars.createInitPosition();

        // then
        assertThat(result).hasSize(names.size());
        assertThat(result)
                .hasEntrySatisfying(names.get(anyInt())
                        , value -> assertThat(value).isEqualTo(INITIAL_CAR_POSITION));
    }

    @DisplayName("경주 자동차 생성시 구분자로 분리한 입력값 중 공백이 있다면 예외가 발생한다.")
    @Test
    void exception_Invalid_Input_Empty() {
        // given
        String input = "apple,,cake";

        // when // then
        assertThatThrownBy(() -> RacingCars.createRacingCars(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BLANK_CAR_NAME.toString());
    }

    @DisplayName("경주 자동차 생성시 구분자로 분리한 입력값이 제한 길이를 초과하면 예외가 발생한다.")
    @Test
    void exception_Invalid_Input_Exceeded_Limit_Length() {
        // given
        String input = "apple,bear,chameleon";

        // when // then
        assertThatThrownBy(() -> RacingCars.createRacingCars(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EXCEEDED_LIMIT_CAR_LENGTH.toString());
    }
}
