package racingcar.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThat;


class RacingCarTest {

    @ParameterizedTest
    @DisplayName("자동차의 이름이 없거나, 5자 이하가 아닐 시 예외가 발생한다.")
    @EmptySource
    @ValueSource(strings = {"tested","testName","      "})
    void validateName(String name){
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new RacingCar(name.trim()));
    }

    @DisplayName("자동차는 전진 또는 멈출 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"0,4", "1,5", "2,6", "3,7", "3,8", "2,9"})
    void applyStatus(int stop, int forward){
        RacingCar racingCar = new RacingCar("TEST");
        Assertions.assertAll(
                () -> assertThat(racingCar.apply(stop)).isEqualTo(CarStatus.STOP),
                () -> assertThat(racingCar.apply(forward)).isEqualTo(CarStatus.FORWARD)
        );
    }

    @DisplayName("이름이 같다면 동일한 자동차로 인식한다.")
    @Test
    void equals(){
        RacingCar expected = new RacingCar("pobi");
        assertThat(new RacingCar("pobi")).isEqualTo(expected);
    }


}