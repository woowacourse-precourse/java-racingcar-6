package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RandomNumberGenerator;


public class CarNamesReaderTest {

    private ByteArrayInputStream inputStream;
    private ByteArrayOutputStream outputStream;
    private PrintStream originalSystemOut;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        originalSystemOut = System.out;
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalSystemOut);
    }

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
        String outputContent = outputStream.toString().trim();
        assertThat(outputContent).isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }
}
