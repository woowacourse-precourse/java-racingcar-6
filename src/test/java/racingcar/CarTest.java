package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.controller.GameController;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.utils.Random;

public class CarTest {
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

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("전진 조건을 올바르게 판단하는가? - 충족X")
    void car_전진조건_충족테스트_충족X(int number) {
        assertThat(Random.isConditionsAdvancementMet(number)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("전진 조건을 올바르게 판단하는가? - 충족O")
    void car_전진조건_충족테스트_충족O(int number) {
        assertThat(Random.isConditionsAdvancementMet(number)).isTrue();
    }

    @Test
    @DisplayName("n대의 자동차는 전진 또는 멈출 수 있는가?")
    void car_자동차_전진_테스트() {
        Cars cars = new Cars();

        Car car1 = new Car("pobi");
        Car car2 = new Car("java");

        cars.addCar(car1);
        cars.addCar(car2);

        assertThat(cars.forwardCondition(car1, 5)).isEqualTo(1);
        assertThat(cars.forwardCondition(car2, 1)).isEqualTo(0);
    }

    @Test
    @DisplayName("주어진 횟수에 맞게 전진 조건을 무작위로 뽑는가?")
    void car_주어진_횟수에_맞게_전진_혹은_멈춤() {
        GameController gameController = new GameController();
        List<String> names = List.of("pobi", "java");
        gameController.initCars(names);

        assertRandomNumberInRangeTest(
                () -> {
                    gameController.racing(2);
                    assertThat(outputStreamCaptor.toString().trim()).contains("pobi : -", "java :", "pobi : -",
                            "java : -");
                },
                4, 0, 0, 4
        );
    }
}
