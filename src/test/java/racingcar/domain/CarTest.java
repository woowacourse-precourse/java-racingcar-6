package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


class CarTest {

    private final static String INVALID_CAR_NAME_LENGTH_MSG = "자동차 이름의 길이는 5이하입니다.";
    private final static String CAR_NAME_EMPTY_MSG = "비어있는 차 이름이 존재합니다.";
    private final static String CAR_NAME_BLANK_MSG = "공백인 이름의 차가 존재합니다.";
    private final static String CAR_NAME_ENG = "차 이름은 영문으로만 이루어져야합니다.";


    @DisplayName("Car 객체를 정상적으로 생성")
    @Test
    void createCarSuccess() {
        List<String> cars = List.of("pobi", "pobii", "aaa");

        for (String car : cars) {
            assertThatCode(() -> new Car(car))
                    .doesNotThrowAnyException();
        }
    }

    @DisplayName("이름이 5글자를 초과할 경우 예외 발생")
    @Test
    void createCarNameOver5_ThrowException() {
        List<String> cars = List.of("pobiii", "abcdefghi", "woniii");
        for (String car : cars) {
            assertThatThrownBy(() -> new Car(car))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(INVALID_CAR_NAME_LENGTH_MSG);
        }
    }

    @DisplayName("이름에 영어가 아닌 다른 문자가 들어간 경우 예외 발생")
    @Test
    void createCarNameNonRegex_ThrowException() {
        List<String> cars = List.of("pob%i", "pobi4", "#$@a", "a b", "a_b", "포비");
        for (String car : cars) {
            assertThatThrownBy(() -> new Car(car))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(CAR_NAME_ENG);
        }
    }

    @DisplayName("이름이 공백일 경우 예외 발생")
    @Test
    void createCarNameEmpty_ThrowException() {
        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CAR_NAME_EMPTY_MSG);
    }

    @DisplayName("이름이 비어 있는 경우 예외 발생")
    @Test
    void createCarNameBlank_ThrowException() {
        List<String> cars = List.of(" ", "   ");
        for (String car : cars) {
            assertThatThrownBy(() -> new Car(car))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(CAR_NAME_BLANK_MSG);
        }
    }

    @DisplayName("자동차가 4 이상의 숫자가 들어올 때 움직임: MOVE")
    @Test
    void moveTest_move() {
        Car car = new Car("pobi");
        NumberGenerator numberGenerator = new TestNumberGenerator(new ArrayList<>(List.of(4, 5, 6, 7, 8, 9)));
        car.move(numberGenerator);
        car.move(numberGenerator);
        car.move(numberGenerator);
        car.move(numberGenerator);
        car.move(numberGenerator);
        car.move(numberGenerator);

        assertThat(car.getPosition()).isEqualTo(6);
    }

    @DisplayName("자동차가 4 미만의 숫자가 들어올 때 움직임: STOP")
    @Test
    void moveTest_stop() {
        Car car = new Car("pobi");
        NumberGenerator numberGenerator = new TestNumberGenerator(new ArrayList<>(List.of(0, 1, 2, 3)));
        car.move(numberGenerator);
        car.move(numberGenerator);
        car.move(numberGenerator);
        car.move(numberGenerator);


        assertThat(car.getPosition()).isEqualTo(0);
    }


    static class TestNumberGenerator implements NumberGenerator{
        private final List<Integer> numbers;

        private TestNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            return numbers.remove(0);
        }
    }

}