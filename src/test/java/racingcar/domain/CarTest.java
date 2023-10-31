package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private Car car;
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @BeforeEach
    public void beforeEach() {
        car = new Car("kim");
    }

    @Test
    @DisplayName("랜덤값이 4이상이면 이동")
    public void move_랜덤값이_4이상이면_1만큼_움직인다() throws Exception {
        int expectDistance = car.getDistance() + 1;
        assertRandomNumberInRangeTest(
                () -> {
                    car.move();
                    assertThat(car.getDistance()).isEqualTo(expectDistance);
                },
                MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("랜덤값이 4이상이면 정지")
    public void move_랜덤값이_4미만이면_움직이지_않는다() throws Exception {
        int expectDistance = car.getDistance();
        assertRandomNumberInRangeTest(
                () -> {
                    car.move();
                    assertThat(car.getDistance()).isEqualTo(expectDistance);
                },
                STOP
        );
    }

    @Test
    @DisplayName("거리가 더 크면 큰 객체로 간주")
    public void compareTo_거리가_크면_더_큰_객체로_간주한다() throws Exception {
        Car lessCar = new Car("kim");
        assertRandomNumberInRangeTest(
                () -> {
                    car.move();
                    assertThat(car).isGreaterThan(lessCar);
                },
                MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("이름이 같으면 같은 객체로 간주")
    public void equals_hashCode_이름이_같으면_같은_객체로_간주한다() throws Exception {
        Car sameCar = new Car("kim");
        assertThat(car).isEqualTo(sameCar);
    }
}