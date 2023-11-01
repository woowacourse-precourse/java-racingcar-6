package racingcar.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;


class CarRepositoryTest {
    private CarRepository carRepository;

    @BeforeEach
    void setUp() {
        carRepository = CarRepository.getInstance();
        carRepository.clean();
    }

    @Test
    public void 저장소_삽입_성공_테스트() {
        //given
        carRepository.add(new Car("test1"));
        carRepository.add(new Car("test2"));

        //when
        int size = carRepository.getCarList().size();

        //then
        Assertions.assertThat(size).isEqualTo(2);
    }
}