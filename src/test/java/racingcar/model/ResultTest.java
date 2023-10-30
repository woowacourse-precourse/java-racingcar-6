package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.lang.reflect.Field;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import racingcar.Application;

public class ResultTest extends NsTest {

    private Result result;
    private RacingCars racingCars;
    private List<String> resultTest;

    @BeforeEach
    void 결과_테스트_셋팅() {
        result = new Result();
        resultTest = new ArrayList<>();
        racingCars = new RacingCars(List.of("car1", "car2", "car3"));
    }

    @Test
    void 결과_단일_우승자_테스트_1() throws NoSuchFieldException, IllegalAccessException {
        List<Car> cars = racingCars.getAllCars();
        Car car1 = cars.get(0);

        Field currentPositionField = Car.class.getDeclaredField("currentPosition");
        currentPositionField.setAccessible(true);
        currentPositionField.set(car1, 3);

        result.findWinnerDistance(racingCars);

        resultTest.add("car1");

        assertThat(result.winnerNameList(racingCars)).isEqualTo(resultTest);
    }
    @Test
    void 결과_단일_우승자_테스트_2() throws NoSuchFieldException, IllegalAccessException {
        List<Car> cars = racingCars.getAllCars();
        Car car1 = cars.get(0);
        Car car2 = cars.get(1);

        Field currentPositionField = Car.class.getDeclaredField("currentPosition");
        currentPositionField.setAccessible(true);
        currentPositionField.set(car1, 3);
        currentPositionField.set(car2, 1);

        result.findWinnerDistance(racingCars);

        resultTest.add("car1");

        assertThat(result.winnerNameList(racingCars)).isEqualTo(resultTest);
    }
    @Test
    void 결과_단일_우승자_테스트_3() throws NoSuchFieldException, IllegalAccessException {
        List<Car> cars = racingCars.getAllCars();
        Car car1 = cars.get(0);
        Car car2 = cars.get(1);
        Car car3 = cars.get(2);

        Field currentPositionField = Car.class.getDeclaredField("currentPosition");
        currentPositionField.setAccessible(true);
        currentPositionField.set(car1, 3);
        currentPositionField.set(car2, 5);
        currentPositionField.set(car3, 100);

        result.findWinnerDistance(racingCars);

        resultTest.add("car3");

        assertThat(result.winnerNameList(racingCars)).isEqualTo(resultTest);
    }

    @Test
    void 결과_여러_우승자_테스트_1() throws NoSuchFieldException, IllegalAccessException {
        List<Car> cars = racingCars.getAllCars();
        Car car1 = cars.get(0);
        Car car2 = cars.get(1);
        Car car3 = cars.get(2);

        Field currentPositionField = Car.class.getDeclaredField("currentPosition");
        currentPositionField.setAccessible(true);
        currentPositionField.set(car1, 3);
        currentPositionField.set(car2, 3);
        currentPositionField.set(car3, 3);

        result.findWinnerDistance(racingCars);

        resultTest.add("car1");
        resultTest.add("car2");
        resultTest.add("car3");

        assertThat(result.winnerNameList(racingCars)).isEqualTo(resultTest);
    }
    @Test
    void 결과_여러_우승자_테스트_2() throws NoSuchFieldException, IllegalAccessException {
        List<Car> cars = racingCars.getAllCars();
        Car car1 = cars.get(0);
        Car car2 = cars.get(1);
        Car car3 = cars.get(2);

        Field currentPositionField = Car.class.getDeclaredField("currentPosition");
        currentPositionField.setAccessible(true);
        currentPositionField.set(car1, 53);
        currentPositionField.set(car2, 100);
        currentPositionField.set(car3, 100);

        result.findWinnerDistance(racingCars);

        resultTest.add("car2");
        resultTest.add("car3");

        assertThat(result.winnerNameList(racingCars)).isEqualTo(resultTest);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}