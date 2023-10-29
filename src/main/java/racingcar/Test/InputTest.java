package racingcar.Test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import racingcar.Car.Car;
import java.util.Arrays;
import racingcar.Computer.RaceManager;
import static org.assertj.core.api.Assertions.assertThat;

public class InputTest {
    @Test
    @DisplayName("첫번째 입력을 받을때 `,`기준으로 잘 구분 되는지 확인 하는 테스트 이다")
    void testFirstInputSeparation() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        List<Car> testCars = Arrays.asList(car1, car2);
        int testRepeatCount = 1;
        new RaceManager(testCars, testRepeatCount);
        assertThat(testCars).contains(car2, car1);
        assertThat(testCars).containsExactly(car1, car2);
    }
    @Test
    @DisplayName("첫번째 입력을 받을때 한개의 값만 입력도 잘 처리 되는지 확인 하는 테스트 이다.")
    void testRunsWithSingleInput() {
        Car car1 = new Car("car1");
        List<Car> testCars = Collections.singletonList(car1);
        assertThat(testCars).contains(car1);
    }

    @Test
    @DisplayName("두번째 입력인 실행횟수가 제대로 입력이되는지 테스트")
    void testRepeatCountInput() {
        List<Car> testCars = Arrays.asList(new Car("car1"), new Car("car2"));
        int inputRepeatCount = 5;
        RaceManager raceManager = new RaceManager(testCars, inputRepeatCount);

        assertThat(raceManager.getRounds()).isEqualTo(inputRepeatCount);
    }
}


