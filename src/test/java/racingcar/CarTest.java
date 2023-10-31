package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.valueObject.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
    @ParameterizedTest(name = "자동차 이름 : {0}")
    @ValueSource(strings = {"j", "woowa"})
    @DisplayName("유효한 이름으로 자동차 생성 테스트 - 1이상, 5이하")
    void carTest(String carName) {
        // given & when
        Car car = new Car(carName);

        // then
        assertThat(car.getName()).isEqualTo(carName);
    }

    @Test
    @DisplayName("자동차 이름 앞 뒤 여백 제거 테스트")
    void carNameTrimTest() {
        // given
        String testName = " hi ";

        // when
        Car car = new Car(testName);

        // then
        assertThat(car.getName()).isEqualTo(testName.trim());
    }

    @Test
    @DisplayName("자동차 이름 null 전달 테스트")
    void creatingNewCarWithNullNameShouldFail() {
        // given
        String nullName = null;

        // when & then
        assertThatThrownBy(() -> new Car(nullName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("이름을 올바르게 입력해 주세요");
    }

    @Test
    @DisplayName("자동차 이름 \"\" 전달 테스트")
    void creatingNewCarWithEmptyNameShouldFail() {
        // given
        String nullName = "";

        // when & then
        assertThatThrownBy(() -> new Car(nullName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("이름의 길이는 \\d+ - \\d+ 사이여야 합니다.");
    }

    @Test
    @DisplayName("이름이 5글자가 넘으면 예외 발생 테스트")
    void nameLengthShouldBeLessThenSix() {
        String overSizedName = "richard";

        assertThatThrownBy(() -> new Car(overSizedName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("이름의 길이는 \\d+ - \\d+ 사이여야 합니다.");
    }

    @ParameterizedTest(name = "전진 - {0}")
    @CsvSource(value = {"true:1", "false:0"}, delimiter = ':')
    @DisplayName("자동차 전진 테스트")
    void advanceTest(boolean isMove, int expected) {
        // given
        Car car = new Car("test");

        // when
        car.forward(() -> isMove);

        // then
        assertThat(car.getPosition()).isEqualTo(expected);
    }

    @Test
    @DisplayName("포지션 동일성 테스트")
    void equalsPosition() {
        // given
        Car car = new Car("test");

        // when
        car.forward(() -> true);

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }
}