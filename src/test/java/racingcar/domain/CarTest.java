package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    void 자동차_정상_생성() {
        //given
        String validName = "pobi";

        //when
        Car car = new Car(validName);

        //then
        assertThat(car.getName()).isEqualTo(validName);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 자동차_전진() {
        //given
        Car car = new Car("name");

        //when
        car.goForward();

        //then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 공백_이름_예외() {
        //given
        String blankName = " ";

        //when & then
        assertThatThrownBy(() -> new Car(blankName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백은 입력 불가능 합니다.");
    }

    @Test
    void 이름_길이_예외() {
        //given
        String longName = "abcdef";

        //when & then
        assertThatThrownBy(() -> new Car(longName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5자 이하의 이름만 가능합니다.");
    }

    @Test
    void 숫자_이름_예외() {
        //given
        String numberName = "123";

        //when & then
        assertThatThrownBy(() -> new Car(numberName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자는 입력 불가능 합니다.");
    }
}
