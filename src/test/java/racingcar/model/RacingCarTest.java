package racingcar.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.constant.CarStatus;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThat;


class RacingCarTest {
    @DisplayName("자동차를 생성할 수 있다")
    @Test
    void init(){
        RacingCar racingCar = new RacingCar("pobi");
        assertThat(racingCar).isInstanceOf(RacingCar.class);
    }

    @DisplayName("이름의 시작과 끝에 공백이 포함되어 있다면 공백을 제거한다.")
    @Test
    void removeSpace(){
        String name = " pobi ";
        RacingCar result = new RacingCar(name);
        RacingCar expected = new RacingCar(name.trim());
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("이름이 같다면 동일한 자동차로 인식한다.")
    @Test
    void equals(){
        RacingCar result = new RacingCar("pobi");
        assertThat(result).isEqualTo(new RacingCar("pobi"));
    }

    @ParameterizedTest
    @DisplayName("자동차의 이름이 없거나, 5자 이하가 아닐 시 예외가 발생한다.")
    @EmptySource
    @ValueSource(strings = {"tested","testName","      "})
    void validateName(String name){
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new RacingCar(name));
    }

    @DisplayName("자동차는 전진 또는 멈출 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"0,4", "1,5", "2,6", "3,7", "3,8", "2,9"})
    void applyStatus(int stopCondition, int forwardCondition){
        RacingCar racingCar = new RacingCar("TEST");
        Assertions.assertAll(
                () -> assertThat(racingCar.decideMove(stopCondition)).isEqualTo(CarStatus.STOP),
                () -> assertThat(racingCar.decideMove(forwardCondition)).isEqualTo(CarStatus.FORWARD)
        );
    }


}