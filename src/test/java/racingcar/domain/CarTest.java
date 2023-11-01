package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @DisplayName("자동차 이름이 1~5글자가 아닐 경우 예외가 발생한다.")
    @CsvSource({"abcdef", "abcdefg", "abcdefgh", "''"})
    @ParameterizedTest
    void invalidNameLengthEx(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름에 특수문자나 숫자가 있으면 예외가 발생한다.")
    @CsvSource({"pobi;", "pobi1", "포비!", "포비2"})
    @ParameterizedTest
    void NotLetterNameEx(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름의 앞뒤 공백을 제거한다.")
    @Test
    void trimName() {
        Car car = new Car("  pobi ");
        assertThat(car.getName()).isEqualTo("pobi");
    }

    @DisplayName("무작위 값이 4이상일 경우 자동차가 전진한다.")
    @CsvSource({"1,0", "2,0", "3,0", "4,1", "5,1",})
    @ParameterizedTest
    void move(int randomNumber, int expected) {
        Car car = new Car("pobi");
        car.move(randomNumber);
        assertThat(car.getMoveCount()).isEqualTo(expected);
    }
}
