package racingcar.domain.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.dto.CarsNameDto;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarGeneratorTest {

    CarGenerator carGenerator;

    @BeforeEach
    void setUp() {
        carGenerator = new CarGenerator(new RandomMove());
    }

    @DisplayName("이름들 입력 시 Car 생성하는지 확인")
    @Test
    void carGeneratorTest() {
        String expectedName1 = "다오";
        String expectedName2 = "디지니";
        String expectedName3 = "배찌";


        String carNames = "다오,디지니,배찌";
        CarsNameDto carsNameDto = new CarsNameDto(carNames);
        carGenerator.generateCars(carsNameDto);

        List<Car> cars = carGenerator.getCars();

        assertThat(cars.get(0).getName())
                .isEqualTo(expectedName1);
        assertThat(cars.get(1).getName())
                .isEqualTo(expectedName2);
        assertThat(cars.get(2).getName())
                .isEqualTo(expectedName3);
    }
}
