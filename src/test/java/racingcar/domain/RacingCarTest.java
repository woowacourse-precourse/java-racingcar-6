package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarPositionDto;
import static org.assertj.core.api.Assertions.assertThat;



class RacingCarTest {
    private RacingCar racingCar;
    @BeforeEach
    void car_생성() {
        String name = "pobi";
        racingCar = new RacingCar(name);
    }

    @Test
    void cars_null_입력시_에러_반환() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new RacingCars(null);
        });
    }

    @Test
    void racingCar_status_초기값_확인() {
        assertThat(racingCar.getPosition()).isZero();
    }

    @Test
    void status_증가_Test() {
        racingCar.move();
        assertThat(racingCar.getPosition()).isEqualTo(1);
    }

    @Test
    void racingCar_name_확인() {
        String name = "pobi";
        assertThat(racingCar.getCarName()).isEqualTo(name);
    }

    @Test
    void racingCar_carPositionDto_확인() {
        CarPositionDto dto = new CarPositionDto(2,"pobi");

        assertThat(dto.getCarName()).isEqualTo("pobi");
        assertThat(dto.getStatus()).isEqualTo(2);
    }




}