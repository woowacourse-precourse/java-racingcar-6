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

class WinnerViewTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }


    @Test
    void 우승자를_출력한다() {

        // given
        List<Car> carList = new ArrayList<>();

        Car car1 = new Car("성겸");
        Car car2 = new Car("성민");

        carList.add(car1);
        carList.add(car2);

        Cars cars = new Cars(carList);

        // when
        WinnerView.displayWinnerView(cars);

        // then
        String capturedOutput = outputStreamCaptor.toString().trim();
        Assertions.assertThat(capturedOutput).isEqualTo("최종 우승자 : 성겸, 성민");
    }
}