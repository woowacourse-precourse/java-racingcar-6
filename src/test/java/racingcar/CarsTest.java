package racingcar;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.Cars;
import racingcar.message.ErrorMessage;

public class CarsTest {

    @DisplayName("createByString 성공 테스트")
    @Test
    void createByStringSuccessTest() {
        Cars cars = Cars.createByString("A,B,C,D");
        Cars answer = new Cars(List.of(
                new Car(new CarName("A")),
                new Car(new CarName("B")),
                new Car(new CarName("C")),
                new Car(new CarName("D")))
        );

        Assertions.assertThat(cars.toString()).isEqualTo(answer.toString());
    }

    @DisplayName("createByString 실패 테스트")
    @Test
    void createByStringFailTest() {
        Assertions.assertThatThrownBy(() -> Cars.createByString("A B C D"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_CAR_NAME);
    }

    @DisplayName("commandAllCarsToMove 를 실행하면 최대 실행 회수까지 전진한다.")
    @Test
    void commandAllCarsToMove() {
        Car car1 = new Car(new CarName("car1"));
        Car car2 = new Car(new CarName("car2"));
        Car car3 = new Car(new CarName("car3"));
        Cars cars = new Cars(List.of(car1, car2, car3));

        cars.commandAllCarsToMove();
        cars.commandAllCarsToMove();
        cars.commandAllCarsToMove();

        Assertions.assertThat(car1.getPosition()).isLessThanOrEqualTo(3);
        Assertions.assertThat(car2.getPosition()).isLessThanOrEqualTo(3);
        Assertions.assertThat(car3.getPosition()).isLessThanOrEqualTo(3);
    }
}
