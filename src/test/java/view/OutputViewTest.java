package view;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import model.Car;
import model.Cars;
import model.MovingCount;
import model.Name;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OutputViewTest {

    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    final PrintStream standardOut = System.out;
    private final OutputView outputView = new OutputView();

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
    void 최종_우승자_출력_테스트() {
        //given
        List<Car> carList = new ArrayList<>();
        Car pobiCar = new Car(new Name("pobi"), new MovingCount(0));
        Car lisaCar = new Car(new Name("lisa"), new MovingCount(0));
        Car jinyCar = new Car(new Name("jiny"), new MovingCount(0));
        pobiCar.increaseMovingCountIfGreater(4, 5);
        lisaCar.increaseMovingCountIfGreater(4, 5);
        carList.add(pobiCar);
        carList.add(lisaCar);
        carList.add(jinyCar);
        Cars cars = new Cars(carList);

        //when
        outputView.displayFinalWinner(cars);

        //then
        Assertions.assertThat(outputStreamCaptor.toString().trim()).isEqualTo("최종 우승자 : pobi,lisa");
    }
}
