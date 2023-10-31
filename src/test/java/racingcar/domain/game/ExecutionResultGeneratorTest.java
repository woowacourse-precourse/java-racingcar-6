package racingcar.domain.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.random_generator.FakeRandomMove;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ExecutionResultGeneratorTest {

    ExecutionResultGenerator executionResultGenerator;

    @BeforeEach
    void setUp() {
        executionResultGenerator = new ExecutionResultGenerator();
    }

    @DisplayName("Car가 움직이지 않을 경우 그려지는 테스트")
    @Test
    void generateExecutionResultTestWhenNotMove() {
        Car car = new Car("test", new FakeRandomMove(0,3));

        car.moveCar();

        String expected = "test : ";

        String result = executionResultGenerator.generateExecutionResult(car);

        assertThat(result)
                .isEqualTo(expected);
    }

    @DisplayName("Car가 움직일 경우 그려지는 테스트")
    @Test
    void generateExecutionResultTestWhenMove() {
        Car car = new Car("test", new FakeRandomMove(4, 9));

        for(int i = 0; i< 3; i++) {
            car.moveCar();
        }

        String expected = "test : ---";

        String result = executionResultGenerator.generateExecutionResult(car);

        assertThat(result)
                .isEqualTo(expected);
    }

    @DisplayName("자동차들이 한 턴 움직일 때 그려지는 테스트")
    @Test
    void generateOneTurnExecutionResultsTest() {
        List<Car> cars = setCars();

        executionResultGenerator.generateOneTurnExecutionResults(cars);

        assertThat(executionResultGenerator.getExecutionResults())
                .containsExactly("test1 : -\n" +
                        "test2 : \n" +
                        "test3 : -\n");
    }

    @DisplayName("자동차들이 한 턴 움직일 때 그려지는 테스트")
    @Test
    void generateAllExecutionResults() {
        List<Car> cars = setCars();

        executionResultGenerator.generateOneTurnExecutionResults(cars);
        String result = executionResultGenerator.generateAllExecutionResults();

        assertThat(result)
                .isEqualTo("""
                        test1 : -
                        test2 :\s
                        test3 : -
                        
                        """);
    }

    private List<Car> setCars() {
        Car car1 = new Car("test1", new FakeRandomMove(4, 9));
        Car car2 = new Car("test2", new FakeRandomMove(0, 3));
        Car car3 = new Car("test3", new FakeRandomMove(4, 9));

        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);


        for (Car car : cars) {
            car.moveCar();
        }
        return cars;
    }
}