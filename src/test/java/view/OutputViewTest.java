package view;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import model.Car;
import model.Cars;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OutputViewTest {

    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    @DisplayName("최종 우승자 출력 테스트")
    public void 최종_우승자_출력_테스트() {
        //given
        List<Car> carList = new ArrayList<>();
        Car pobiCar = new Car("pobi");
        Car lisaCar = new Car("lisa");
        Car jinyCar = new Car("jiny");
        pobiCar.increaseMovingCountIfGreater(4, 5);
        lisaCar.increaseMovingCountIfGreater(4, 5);
        carList.add(pobiCar);
        carList.add(lisaCar);
        carList.add(jinyCar);
        Cars cars = new Cars(carList);

        //when
        OutputView.displayFinalWinner(cars);

        //then
        Assertions.assertThat(outputStreamCaptor.toString().trim()).isEqualTo("최종 우승자 : pobi,lisa");
    }
}
