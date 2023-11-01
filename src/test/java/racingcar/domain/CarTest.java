package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Car car;
    private static final int MOVE_CONDITION = 4;

    @BeforeEach
    void setUp() {
        car = new Car("Test");
    }
    @Test
    void Car의_이름_반환() {
        assertThat(car.getName()).isEqualTo("Test");
    }

    @Test
    void 생성시_초기_위치_확인() {
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 랜덤_숫자가_4_이상일_때_전진() {
        car.move(MOVE_CONDITION);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 랜덤_숫자가_4_미만일_때_멈춤() {
        car.move(MOVE_CONDITION - 1);
        assertThat(car.getPosition()).isEqualTo(0);
    }

}
