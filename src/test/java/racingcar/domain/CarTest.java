package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("자동차 객체 생성")
    public void createCarInstance() {
        // given
        String testCar = "phobi";
        // when
        Car car = Car.of(testCar);
        // then
        assertThat(car).isNotNull();
        assertThat(car).isInstanceOf(Car.class);

    }

    @Test
    @DisplayName("자동차 이름이 6글자 이상일 경우 IllegalArgumentException 발생")
    public void checkOver5Letters() {
        // given
        String testCar = "javagili";

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Car.checkOver5Letters(testCar))
                .withMessageMatching("자동차 이름은 6글자 이상일 수 없습니다.");
    }

    @Test
    @DisplayName("자동차 이름에 공백만 있을 경우 IllegalArgumentException 발생")
    public void checkCarWithBlank() {
        // given
        String testCar = " ";

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Car.checkCarWithBlank(testCar))
                .withMessageMatching("자동차 이름에 공백만 있을 수 없습니다.");
    }
}