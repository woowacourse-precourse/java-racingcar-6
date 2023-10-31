package mytest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import racingcar.model.Car;

public class TrialsTest {
    private final Car car = new Car("pobi");

    @DisplayName("전진 여부 확인 테스트")
    @Test
    void 전진_여부_확인_테스트() {
        //given
        int position = car.getPosition();
        //when
        car.forward();
        //then
        assertThat(car.getPosition()).isEqualTo(position+1);
    }

}
