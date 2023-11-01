package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
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
        boolean isWinner = car.isWinner(0);
        assertThat(isWinner).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,-1,-5,11})
    void isWinner_fail(int maxMoveCnt) {
        boolean isWinner = car.isWinner(maxMoveCnt);
        assertThat(isWinner).isFalse();
    }

}