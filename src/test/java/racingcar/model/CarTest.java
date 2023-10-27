package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("create 생성 테스트 : Car 생성 시 이름을 부여할 수 있다.")
    @Test
    void create() {
        Car car = new Car("홍길동");
        assertThat(car).isEqualTo(new Car("홍길동"));
    }

    @DisplayName("name 사이즈 5이하 테스트 : 5이하가 아니라면 IllegalArgumentException가 발생한다.")
    @Test
    void name_size_less_than_5() {
        assertThatThrownBy(() -> new Car("홍길동홍길동"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름 크기는 5이하여야 합니다.");
    }
}