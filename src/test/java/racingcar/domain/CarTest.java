package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    private Car car;

    @BeforeEach
    void init() {
        car = new Car("povi");
    }

    @Test
    void 자동차_생성_테스트() {
        Assertions.assertThat(car).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "5글자가 넘는 이름", ""})
    void 자동차_이름_유효성검사(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @ParameterizedTest
    @CsvSource(value = {"4:1", "5:1"}, delimiter = ':')
    void 자동차_전진_테스트(int input, int expect) {
        assertThat(car.move(input)).isEqualTo(expect);
    }


    @ParameterizedTest
    @ValueSource(ints = {0, 3})
    void 자동차_정지_테스트(int input) {
        assertThat(car.move(input)).isEqualTo(0);
    }


}