package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.constants.GameMessage;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Winners;
import racingcar.view.OutputView;

public class OutputTest {
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
    @DisplayName("각 차수별 실행 결과 테스트")
    void output_실행결과() {
        Cars cars = new Cars();

        Car car1 = new Car("pobi");
        Car car2 = new Car("java");

        cars.addCar(car1);
        cars.addCar(car2);

        car1.setDistance(cars.forwardCondition(car1, 4));
        car2.setDistance(cars.forwardCondition(car2, 3));

        OutputView.displayRacingSituation(cars);
        String result = "pobi : -" + System.lineSeparator() + "java :";

        assertThat(result).isEqualTo(outputStreamCaptor.toString().trim());
    }

    @Test
    @DisplayName("단독 우승자 출력 테스트")
    void output_단독_우승자() {
        Cars cars = new Cars();

        Car car1 = new Car("pobi");
        Car car2 = new Car("java");

        cars.addCar(car1);
        cars.addCar(car2);

        car1.setDistance(1);
        car2.setDistance(3);

        OutputView.displayWinner(new Winners(cars));

        String result = GameMessage.OUTPUT_WINNER_ANNOUNCEMENT.getMessage() + "java";
        assertThat(result).isEqualTo(outputStreamCaptor.toString().trim());
    }

    @Test
    @DisplayName("공동 우승자 출력 테스트")
    void output_공동_우승자() {
        Cars cars = new Cars();

        Car car1 = new Car("pobi");
        Car car2 = new Car("java");

        cars.addCar(car1);
        cars.addCar(car2);

        car1.setDistance(3);
        car2.setDistance(3);

        OutputView.displayWinner(new Winners(cars));

        String result = GameMessage.OUTPUT_WINNER_ANNOUNCEMENT.getMessage() + "pobi, java";
        assertThat(result).isEqualTo(outputStreamCaptor.toString().trim());
    }
}
