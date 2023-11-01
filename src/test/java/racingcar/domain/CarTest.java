package racingcar.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    public static Car car;
    @BeforeAll
    public static void initializer(){
        car = new Car("jun");
    }
    @Test
    @DisplayName("자동차_이름_접근자_테스트")
    void getName() {
        // given
        String name;
        // when
        name = car.getName();
        // then
        assertThat(name).isEqualTo("jun");
    }

    @Test
    @DisplayName("자동차_위치_접근자_테스트")
    void getPosition() {
        // given
        Integer moveDistance;
        // when
        moveDistance = car.getMoveDistance();
        // then
        assertThat(moveDistance).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차_이동_함수_테스트")
    void move() {
        // given
        Integer moveDistance;
        // when
        for(int i = 0;i < 5;i++){
            car.moveForward();
        }
        moveDistance = car.getMoveDistance();
        // then
        assertThat(moveDistance).isLessThanOrEqualTo(5);
    }
}