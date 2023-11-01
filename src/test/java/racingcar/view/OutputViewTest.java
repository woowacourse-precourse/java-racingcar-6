package racingcar.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }


    @Test
    void 실행결과를_출력한다() {
        // given
        List<Car> carList = new ArrayList<>();

        Car car = new Car("성겸");
        car.incrementDistance();
        car.incrementDistance();
        carList.add(car);

        Cars cars = new Cars(carList);

        // when
        OutputView.displayOutputView(cars);

        // then
        String capturedOutput = outputStreamCaptor.toString().trim();
        Assertions.assertThat(capturedOutput).isEqualTo("성겸 : --");
    }
}