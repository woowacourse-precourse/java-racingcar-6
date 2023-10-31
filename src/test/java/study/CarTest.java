package study;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {


    @Test
    void 생성_유효한_자동차() {
        // 유효한 자동차 이름인 경우
        Car car = new Car("pobi");
        assertThat(car.getName()).isEqualTo("pobi");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 생성_무효한_자동차_이름() {
        // 무효한 자동차 이름인 경우
        assertThatThrownBy(() -> new Car("")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Car("123456")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이동_결과_문자열_확인() {
        Car car = new Car("pobi");
        assertThat(car.getMoveResult()).isEqualTo("");
        car.move(5);
        assertThat(car.getMoveResult()).isEqualTo("-");
    }
}
