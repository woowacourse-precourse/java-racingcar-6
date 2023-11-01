package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarsTest {
    private final Cars cars = Cars.create();

    @Test
    void 랜덤값이_4이상이면_전진횟수가_증가하는지() {
        String[] carArr = {"a", "b", "c"};
        cars.init(carArr);
        assertThat(cars.getPosition(0)).isEqualTo(0);

        int randomNum = 4;
        cars.plusNum(0, randomNum);
        assertThat(cars.getPosition(0)).isEqualTo(1);
    }

    @Test
    void 랜덤값이_4미만이면_전진횟수가_증가X() {
        String[] carArr = {"a", "b", "c"};
        cars.init(carArr);
        assertThat(cars.getPosition(0)).isEqualTo(0);

        int randomNum = 3;
        cars.plusNum(0, randomNum);
        assertThat(cars.getPosition(0)).isEqualTo(0);
    }
}