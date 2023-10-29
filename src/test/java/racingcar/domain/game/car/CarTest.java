package racingcar.domain.game.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.dto.CarMovementDto;

class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = Car.from(CarName.from("benz"));
    }

    @DisplayName("Car 객체를 생성할 수 있는지 검증")
    @Test
    void should_Create_Cars() {
        assertThat(car).isNotNull();
    }

    @DisplayName("Car가 한 번 움직일 때마다 position이 1씩 증가하는지 확인")
    @Test
    void should_Increment_Position_On_Move() {
        // when
        car.moveOnce();

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("CarMovementDto로 변환 시 유효한 데이터를 제공하는지 확인")
    @Test
    void should_Provide_Valid_CarMovementDto() {
        // when
        CarMovementDto carMovementDto = car.toCarMovementDto();

        // then
        assertThat(carMovementDto.carName().getName()).isEqualTo("benz");
        assertThat(carMovementDto.position()).isEqualTo(0);
    }

    @DisplayName("CarName에서 자동차 이름 문자열을 가져올 수 있는지 확인")
    @Test
    void should_Get_CarName_String_From_CarName_Object() {
        // when
        String carName = car.getCarName();

        // then
        assertThat(carName).isEqualTo("benz");
    }

    @DisplayName("자동차가 주어진 maxPosition과 같은 postion에 있는지 확인")
    @Test
    void should_Check_If_Car_Is_At_Given_Position() {
        // given
        car.moveOnce();

        // when
        // then
        assertThat(car.isSameAs(0)).isFalse();
        assertThat(car.isSameAs(1)).isTrue();
    }
}