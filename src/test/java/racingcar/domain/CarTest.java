package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("자동차 이름의 길이가 6글자 이상일 경우 예외가 발생한다.")
    @Test
    void test() {
        //given
        String str = "가나다라마바";

        //then
        Assertions.assertThatThrownBy(() -> new Car(str))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름의 길이가 공백이 포함되어 있지 않는 5글자 이하 일 경우 정상적으로 Car 객체가 생성된다.")
    @Test
    void test123() {
        //given
        String str = "가나다라마";

        //then
        Assertions.assertThat(new Car(str)).isInstanceOf(Car.class);
    }

    @DisplayName("자동차 이름 중 공백이 있을 경우 예외가 발생한다.")
    @Test
    void test123123() {
        //given
        String str = "가 나다라마";

        //then
        Assertions.assertThatThrownBy(() -> new Car(str))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름이 입력되지 않는다면 예외가 발생한다.")
    @Test
    void test123121233() {
        //given
        String str = "";

        //then
        Assertions.assertThatThrownBy(() -> new Car(str))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
