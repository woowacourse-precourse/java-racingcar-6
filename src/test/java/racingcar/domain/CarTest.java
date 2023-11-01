package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.dto.PerGameCarResultDto;

class CarTest {

    Car car = new Car("car");

    @Test
    void getRandomNum() {
        int randomNum = car.getRandomNum();
        assertThat(randomNum).isGreaterThan(-1).isLessThan(10);
    }

    @Test
    void moveForward() {
        int moveCnt = car.getCarStatus().moveCnt();
        car.moveForward();
        assertThat(moveCnt + 1).isEqualTo(car.getCarStatus().moveCnt());
    }

    @Test
    void getCarStatus() {
        assertThat(car.getCarStatus().getClass()).isEqualTo(PerGameCarResultDto.class);

        PerGameCarResultDto carStatus = car.getCarStatus();
        assertThat(carStatus.carName()).isEqualTo(car.getName());
    }

    @Test
    void isWinner() {
    }

    @Test
    void getName() {
    }
}