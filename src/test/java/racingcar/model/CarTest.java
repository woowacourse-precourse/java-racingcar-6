package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    @DisplayName("Car가 제대로 생성되었는지 확인한다 (정확한 이름 반환)")
    void 객체_생성_이름확인() {
        //given
        Car car = new Car("seona");
        //then
        assertThat(car.getName()).isEqualTo("seona");
    }

    @Test
    @DisplayName("Car가 제대로 생성되었는지 확인한다 (생성시 거리는 0)")
    void 객체_생성_거리확인() {
        //given
        Car car = new Car("seona");
        //then
        assertThat(car.getMovement()).isEqualTo(0);
    }
}