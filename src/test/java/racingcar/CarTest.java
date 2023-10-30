package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;
import racingcar.car.CarFactory;

public class CarTest extends NsTest {
    @Test
    void 차_생성_테스트() {
        String testCarName = "찬";
        List<Car> cars = CarFactory.createCar(testCarName);

        assertThat(cars).hasSize(1);
        assertThat(cars.get(0).getName()).isEqualTo(testCarName);
    }

    @Test
    void 복수의_차_생성_테스트() {
        List<String> carNames = Arrays.asList("java", "spring", "gradle");

        String testCarNames = String.join(",", carNames);
        List<Car> cars = CarFactory.createCar(testCarNames);

        assertThat(cars).hasSize(3);
        assertThat(cars.get(0).getName()).isEqualTo(carNames.get(0));
        assertThat(cars.get(1).getName()).isEqualTo(carNames.get(1));
        assertThat(cars.get(2).getName()).isEqualTo(carNames.get(2));
    }

    @Test
    void 공백이_포함된_차_이름_입력값_테스트() {
        String testCarName = "우 아";

        assertThatThrownBy(() -> CarFactory.createCar(testCarName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 특수문자가_포함된_차_이름_입력값_테스트() {
        String testCarName = "차!";

        assertThatThrownBy(() -> CarFactory.createCar(testCarName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
