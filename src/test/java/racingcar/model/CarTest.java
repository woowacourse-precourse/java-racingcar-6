package racingcar.model;

import model.Car;
import model.Cars;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * packageName    : racingcar.model
 * fileName       : CarTest
 * author         : qkrtn_ulqpbq2
 * date           : 2023-10-30
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-10-30        qkrtn_ulqpbq2       최초 생성
 */
public class CarTest {

    @Test
    @DisplayName("자동차 정상 생성")
    public void success() {
        Car car = new Car("test");
        assertThat(car).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {" "})
    @DisplayName("자동차 리스트 생성 실패")
    public void failed(String string) {
        assertThatThrownBy(() -> new Car(string)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 5자보다 클 경우 예외 발생")
    public void carNameLong(){
        String carNames = "javaji";

        assertThatThrownBy(() -> new Car(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 빈값일 경우 예외 발생")
    public void carNameEmpty(){
        String carNames = "";

        assertThatThrownBy(() -> new Car(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 전진")
    public void Go(){
        goOrStopTest(6, 1);
    }

    @Test
    @DisplayName("자동차 멈춤")
    public void Stop(){
        goOrStopTest(2, 0);
    }

    private void goOrStopTest(int random, int expected) {
        Car car = new Car("test");
        car.goOrStop(random);
        assertThat(car.getPosition()).isEqualTo(expected);
    }
}
