package racingcar.util;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.model.car.Car;
import racingcar.model.car.CarList;
import racingcar.util.CarNameValidator.Message;

public class CarNameValidatorTest {
    @Nested
    @DisplayName("비정상 입력값")
    class 비정상_입력값_검사 {
        @Test
        @DisplayName("자동차의 수가 1대 이하일 경우 예외처리")
        void 자동차_수_검사() {
            Car car1 = new Car("car1");
            List<Car> carList = new ArrayList<>(List.of(car1));

            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new CarList(carList))
                    .withMessage(Message.EXCEPTION_CAR_NUMBER.getMessage());
        }

        @Test
        @DisplayName("자동차 이름이 6자 이상일 경우 예외처리")
        void 자동차_이름_검사() {
            Car car1 = new Car("car1");
            Car car2 = new Car("car2car2");
            List<Car> carList = new ArrayList<>(List.of(car1, car2));

            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new CarList(carList))
                    .withMessage(Message.EXCEPTION_CARNAME_LENGTH.getMessage());
        }

        @Test
        @DisplayName("이름이 중복될 경우 예외처리")
        void 이름_중복_검사() {
            Car car1 = new Car("car1");
            Car car2 = new Car("car1");
            List<Car> carList = new ArrayList<>(List.of(car1, car2));

            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new CarList(carList))
                    .withMessage(Message.EXCEPTION_CARNAME_SAME.getMessage());
        }

        @Test
        @DisplayName("이름이 공백을 포함할 경우 예외처리")
        void 이름_공백_포함_검사() {
            Car car1 = new Car("c a r");
            Car car2 = new Car("car1");
            List<Car> carList = new ArrayList<>(List.of(car1, car2));

            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new CarList(carList))
                    .withMessage(Message.EXCEPTION_BLANK.getMessage());
        }
    }

    @Nested
    @DisplayName("정상 입력값")
    class 정상_입력값_검사 {
        @Test
        @DisplayName("자동차 이름이 올바를 경우")
        void 자동차_이름_정상_입력() {
            Car car1 = new Car("car1");
            Car car2 = new Car("car2");
            List<Car> carList = new ArrayList<>(List.of(car1, car2));

            assertThatCode(() -> new CarList(carList)).doesNotThrowAnyException();
        }
    }
}
