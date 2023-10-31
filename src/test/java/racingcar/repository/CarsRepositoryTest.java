package racingcar.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarsRepositoryTest {
    private CarsRepository carsRepository = new CarsRepository();

    @Test
    void 랜덤값이_4이상이면_전진횟수가_증가하는지() {
        String[] cars = {"a", "b", "c"};
        carsRepository.initCars(cars);
        assertThat(carsRepository.getPosition(0)).isEqualTo(0);

        int randomNum = 4;
        carsRepository.plusNum(0, randomNum);
        assertThat(carsRepository.getPosition(0)).isEqualTo(1);
    }

    @Test
    void 랜덤값이_4미만이면_전진횟수가_증가X() {
        String[] cars = {"a", "b", "c"};
        carsRepository.initCars(cars);
        assertThat(carsRepository.getPosition(0)).isEqualTo(0);

        int randomNum = 3;
        carsRepository.plusNum(0, randomNum);
        assertThat(carsRepository.getPosition(0)).isEqualTo(0);
    }
}