package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CarTest {

    @Test
    public void 자동차_이름_길이제한_성공() {
        // 5자 이하의 이름으로 Car 객체 생성
        String name = "pobi";
        Car car = new Car(name);
        assertThat(car.getName()).isEqualTo(name);
    }

    @Test
    public void 자동차_이름_길이제한_실패() {
        // 6자의 이름으로 Car 객체 생성 시도
        String longName = "pobibibi";
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Car(longName))
                .withMessage("자동차 이름은 5자 이하만 가능합니다.");
    }

}