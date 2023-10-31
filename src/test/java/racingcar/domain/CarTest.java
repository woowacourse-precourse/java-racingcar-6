package racingcar.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.anyOf;
import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    public static Car car;
    @BeforeAll
    public static void initializer(){
        car = new Car("pobie");
    }
    @Test
    @DisplayName("자동차_이름_접근자_테스트")
    void getName() {
        // given
        String name;
        // when
        name = car.getName();
        // then
        assertThat(name).isEqualTo("pobie");
    }

    @Test
    @DisplayName("자동차_위치_접근자_테스트")
    void getPosition() {
        // given
        Integer position;
        // when
        position = car.getPosition();
        // then
        assertThat(position).isEqualTo(0); // 초기 위치는 0임.
    }

    @Test
    @DisplayName("자동차_이동_함수_테스트")
    void move() {
        // given
        Integer position;
        // when
        for(int i = 0;i < 5;i++){
            car.move();
        }
        position = car.getPosition();
        // then
        assertThat(position).isLessThanOrEqualTo(5);
    }
}