package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {

    @Test
    @DisplayName("이름을 가진 자동차를 만들 수 있다.")
    void create_car_with_name_success() {
        assertThat(new Car("jae")).isInstanceOf(Car.class);
    }

    @Test
    @DisplayName("자동차 이름은 5글자 이상일 수 없다")
    void create_car_with_name_fail_over_max_length() {
        assertThatThrownBy(() -> new Car("jaehun123"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @Test
    @DisplayName("자동차 이름은 빈 글자일 수 없다")
    void create_car_with_name_fail_blank() {
        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 빈 값일 수 없습니다.");
    }
}
