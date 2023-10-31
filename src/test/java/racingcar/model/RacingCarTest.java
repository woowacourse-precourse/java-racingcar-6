package racingcar.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.Constants;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarTest {
    private RacingCar racingCar = RacingCar.from("oyoun");

    @ParameterizedTest
    @ValueSource(strings = {"poni", "woni", "12345"})
    void from_정상적으로생성한다(String name) {
        RacingCar racingCar = RacingCar.from(name);
        assertThat(racingCar.getName()).isEqualTo(name);
        assertThat(racingCar.getDistance()).isEqualTo(Constants.CAR_INIT_DISTANCE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"poni56", "woni56", "123456"})
    void validate_5글자이상_이름들을_받으면_예외를_반환한다(String name_len5) {
        assertThatThrownBy(() -> RacingCar.from(name_len5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"po,", "w ,n", ",345"})
    void validate_쉼표포함_이름들을_받으면_예외를_반환한다(String name_comma) {
        assertThatThrownBy(() -> RacingCar.from(name_comma))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "        "})
    void validate_빈문자열을_받으면_예외를_반환한다(String name_space) {
        assertThatThrownBy(() -> RacingCar.from(name_space))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void move_GOnum넣으면_이동한다() {
        NumberGenerator numberGenerator = new GONumberGenerator();
        racingCar.move(numberGenerator);
        assertThat(racingCar.getDistance()).isEqualTo(1);
    }

    @Test
    void move_STOPnum넣으면_이동한다() {
        NumberGenerator numberGenerator = new STOPNumberGenerator();
        racingCar.move(numberGenerator);
        assertThat(racingCar.getDistance()).isEqualTo(0);
    }
}