package racingcar.model;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.lang.reflect.Field;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import racingcar.Application;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class ResultTest extends NsTest {

    private Result result;
    private RacingCars racingCars;
    private List<String> resultTest;

    @BeforeEach
    void 결과_테스트_셋팅() {
        resultTest = new ArrayList<>();
        racingCars = new RacingCars(List.of("car1", "car2", "car3"));
    }

    /**
     * 우승자를 임의로 지정하기 위해서 currentPosition을 강제로 컨트롤했습니다.
     * moveIfRandomSuccess는 확률로 움직이기에 Test에서 적합하지 않다고 판단했습니다.
     */
    @Test
    void 결과_단일_우승자_테스트_시나리오1() throws Exception {
        List<Car> cars = racingCars.getAllCars();
        Car car1 = cars.get(0);

        Field currentPositionField = Car.class.getDeclaredField("currentPosition");
        currentPositionField.setAccessible(true);
        currentPositionField.set(car1, 3);

        result = new Result(racingCars);

        resultTest.add("car1");

        assertThat(result.getWinnerNames()).isEqualTo(resultTest);
    }

    @Test
    void 결과_단일_우승자_테스트_시나리오2() throws Exception {
        List<Car> cars = racingCars.getAllCars();
        Car car1 = cars.get(0);
        Car car2 = cars.get(1);

        Field currentPositionField = Car.class.getDeclaredField("currentPosition");
        currentPositionField.setAccessible(true);
        currentPositionField.set(car1, 3);
        currentPositionField.set(car2, 1);

        result = new Result(racingCars);

        resultTest.add("car1");

        assertThat(result.getWinnerNames()).isEqualTo(resultTest);
    }

    @Test
    void 결과_단일_우승자_테스트_시나리오3() throws Exception {
        List<Car> cars = racingCars.getAllCars();
        Car car1 = cars.get(0);
        Car car2 = cars.get(1);
        Car car3 = cars.get(2);

        Field currentPositionField = Car.class.getDeclaredField("currentPosition");
        currentPositionField.setAccessible(true);
        currentPositionField.set(car1, 3);
        currentPositionField.set(car2, 5);
        currentPositionField.set(car3, 100);

        result = new Result(racingCars);

        resultTest.add("car3");

        assertThat(result.getWinnerNames()).isEqualTo(resultTest);
    }

    @Test
    void 결과_여러_우승자_테스트_시나리오1() throws Exception {
        List<Car> cars = racingCars.getAllCars();
        Car car1 = cars.get(0);
        Car car2 = cars.get(1);
        Car car3 = cars.get(2);

        Field currentPositionField = Car.class.getDeclaredField("currentPosition");
        currentPositionField.setAccessible(true);
        currentPositionField.set(car1, 3);
        currentPositionField.set(car2, 3);
        currentPositionField.set(car3, 3);

        result = new Result(racingCars);

        resultTest.add("car1");
        resultTest.add("car2");
        resultTest.add("car3");

        assertThat(result.getWinnerNames()).isEqualTo(resultTest);
    }

    @Test
    void 결과_여러_우승자_테스트_시나리오2() throws Exception {
        List<Car> cars = racingCars.getAllCars();
        Car car1 = cars.get(0);
        Car car2 = cars.get(1);
        Car car3 = cars.get(2);

        Field currentPositionField = Car.class.getDeclaredField("currentPosition");
        currentPositionField.setAccessible(true);
        currentPositionField.set(car1, 53);
        currentPositionField.set(car2, 100);
        currentPositionField.set(car3, 100);

        result = new Result(racingCars);

        resultTest.add("car2");
        resultTest.add("car3");

        assertThat(result.getWinnerNames()).isEqualTo(resultTest);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}