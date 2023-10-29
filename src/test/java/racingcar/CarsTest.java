package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.common.RandomNumberGenerator;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.dto.CarDtos;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CarsTest {
    private RandomNumberGenerator testRandomNumberGenerator;

    @BeforeEach
    void setUp() {
        testRandomNumberGenerator = new TestRandomNumberGenerator(4);
    }

    @Test
    void 자동차_그룹_생성() {
        assertDoesNotThrow(() -> new Cars("pobi, crong, honux", testRandomNumberGenerator));
    }

    @Test
    void 자동차_그룹_전진_테스트() {
        Cars cars = new Cars("pobi, crong, honux", testRandomNumberGenerator);
        cars.forEach(Car::move);
        CarDtos carDtos = cars.toCarDtos();

        assertEquals(1, carDtos.getCarDtos().get(0).getPosition());
        assertEquals(1, carDtos.getCarDtos().get(1).getPosition());
        assertEquals(1, carDtos.getCarDtos().get(2).getPosition());
    }

    @Test
    void 자동차_그룹_멈춤_테스트() {
        RandomNumberGenerator stopRandomNumberGenerator = new TestRandomNumberGenerator(3);
        Cars cars = new Cars("pobi, crong, honux", stopRandomNumberGenerator);
        cars.forEach(Car::move);
        CarDtos carDtos = cars.toCarDtos();

        assertEquals(0, carDtos.getCarDtos().get(0).getPosition());
        assertEquals(0, carDtos.getCarDtos().get(1).getPosition());
        assertEquals(0, carDtos.getCarDtos().get(2).getPosition());
    }
}
