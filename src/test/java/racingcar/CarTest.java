package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;

class CarTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    void setUpOutputStream() {
        System.setOut(new PrintStream(output));
    }

    void restoreOutputStream() {
        System.setOut(System.out);
        output.reset();
    }

    @DisplayName("자동차 이름이 5글자 이하면 예외가 발생하지 않는다")
    @ParameterizedTest
    @ValueSource(strings = {"a", "ab", "abc", "abcd", "abcde"})
    void carName(String name) {
        assertThatCode(() -> new Car(name)).doesNotThrowAnyException();
    }

    @DisplayName("자동차 이름이 5글자 이하가 아니면 IllegalArgumentException 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = "aaaaaa")
    void carNameException(String name) {
        assertThatThrownBy(() -> new Car(name)).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("생성된 숫자가 4이상일때 true를 반환하고 미만일때는 false값을 반환해야한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
    void canMove(int generateNumber) {
        Car car = new Car("test");
        boolean expected = generateNumber >= 4;
        assertThat(car.canMove(generateNumber)).isEqualTo(expected);
    }

    @DisplayName("자동차가 정상적으로 이동하는지 검사한다.")
    @Test
    void move() {
        Car car = new Car("test");
        car.move(true);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("자동차의 상태를 정상적으로 출력하는지 검사한다.")
    @Test
    void printCarStatus() {
        setUpOutputStream();

        Car car = new Car("test");
        car.move(true);
        car.printCarStatus();

        assertThat(output.toString().trim()).isEqualTo("test : -");

        restoreOutputStream();
    }
}