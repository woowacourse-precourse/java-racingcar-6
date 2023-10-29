package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void 자동차_객체_생성() {
        Car carObj = new Car("vega");

        assertThat(carObj).isNotNull();
        assertThat(carObj.getCarName()).isEqualTo("vega");
    }

    @Test
    void 자동차이름_길이제한() {
        Car carObj = new Car("vega");
        int limitNameLength = 5;

        assertThat(carObj.getCarName().length()).isLessThanOrEqualTo(limitNameLength);
    }

    @Test
    void 자동차이름_공백검사() {
        Car carObj = new Car("vega");

        assertThat(carObj.getCarName()).doesNotContainAnyWhitespaces();
    }

    @Test
    void 랜덤수_정상적인지_확인() {
        Car carObj = new Car("vega");

        assertThat(carObj.getRandomNumber()).isBetween(0, 9);
    }
}
