package racingcar.domain.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.dto.CarsNameDto;
import racingcar.domain.car.random_generator.TrueRandomMove;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {

    Cars cars;

    @BeforeEach
    void setUp() {
        String carNames = "다오,디지니,배찌";
        CarsNameDto carsNameDto = new CarsNameDto(carNames);

        cars = new Cars(new TrueRandomMove(), carsNameDto.names());
        cars.generateCars(carsNameDto.names());
    }

    @DisplayName("이름들 입력 시 Car 생성하는지 확인")
    @Test
    void carGeneratorTest() {
        String expectedName1 = "다오";
        String expectedName2 = "디지니";
        String expectedName3 = "배찌";

        List<Car> cars = this.cars.getCars();

        assertThat(cars.get(0).getName())
                .isEqualTo(expectedName1);
        assertThat(cars.get(1).getName())
                .isEqualTo(expectedName2);
        assertThat(cars.get(2).getName())
                .isEqualTo(expectedName3);
    }

    @DisplayName("자동차들 움직이는 경우 실행 결과 잘 나오는지 확인")
    @Test
    void carExecutionResultAllCarsTest() {
        String expectedResult = """
                다오 : ---
                디지니 : ---
                배찌 : ---""";
        int moveCount = 3;
        for(int i = 0; i<moveCount; i++) {
            cars.runRace();
        }
        String result = cars.generateExecutionResultAllCars();

        assertThat(expectedResult)
                .isEqualTo(result);
    }

}
