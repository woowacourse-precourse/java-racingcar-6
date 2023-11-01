package racingcar.processor;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarDataProcessorTest {

    private final Request request = new Request();
    private final CarDataProcessor processor = new CarDataProcessor(request);

    @Test
    @DisplayName("입력받은 Car 이름들을 분리해 저장할 수 있다.")
    void saveCars() {
        String inputCars = "woo,wa,cour,se";

        List<Car> cars = processor.saveCars(inputCars);

        assertAll(
                () -> assertThat(cars.size()).isEqualTo(4),
                () -> assertThat(cars.get(0).getName()).isEqualTo("woo"),
                () -> assertThat(cars.get(1).getName()).isEqualTo("wa"),
                () -> assertThat(cars.get(2).getName()).isEqualTo("cour"),
                () -> assertThat(cars.get(3).getName()).isEqualTo("se")
        );
    }
}
