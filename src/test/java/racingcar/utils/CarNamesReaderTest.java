package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RandomNumberGenerator;


public class CarNamesReaderTest {

    private ByteArrayInputStream inputStream;

    @Test
    public void 자동차객체리스트_생성_테스트() {
        // 모의 입력값 설정
        String input = "car1,car2,car3\n";
        inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(inputStream);

        List<Car> cars = CarNamesReader.get();

        List<Car> expectedCars = Arrays.asList(
                new Car("car1", new RandomNumberGenerator()),
                new Car("car2", new RandomNumberGenerator()),
                new Car("car3", new RandomNumberGenerator())
        );
        for (int i = 0; i < cars.size(); i++) {
            Car actualCar = cars.get(i);
            Car expectedCar = expectedCars.get(i);
            assertThat(actualCar.getName()).isEqualTo(expectedCar.getName());
        }
    }
}
