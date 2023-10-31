package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TypeCastingTest {
    @Test
    @DisplayName("String 에서 RacingCars로 잘 변환 되었는지 판단")
    void Given_String_When_TypeCasted_Then_ClassHasChanged() {
        // given
        String string = "abc,def";
        // when
        RacingCars racingCars = TypeCasting.stringToRacingCars(string);

        // then
        assertThat(racingCars).isInstanceOf(RacingCars.class);
    }
}