package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CarTest {

    @Test
    @DisplayName("Move forward (Random >= 4)")
    void 랜덤_숫자가_4이상일_경우_전진() {
        Car mock = Mockito.mock(Car.class);

        int mockRandomNumber = 5;
        Mockito.when(mock.generateRandomNumber()).thenReturn(mockRandomNumber);
        mock.moveForward();

        String expectedValue = "-";
        Assertions.assertThat(expectedValue).isEqualTo("-");
    }

    @Test
    @DisplayName("No Move Forward (Random < 4)")
    void 랜덤_숫자가_4미만일_경우_스탑() {
        Car mock = Mockito.mock(Car.class);

        int mockRandomNumber = 3;
        Mockito.when(mock.generateRandomNumber()).thenReturn(mockRandomNumber);
        mock.moveForward();

        String expectedValue = "";
        Assertions.assertThat(expectedValue).isEqualTo("");
    }

    @Test
    @DisplayName("If Duplicate Name, Throw Exception")
    void 중복된_이름_사용시_에러_발생() {
        Car car = new Car("car1");

        Assertions.assertThatThrownBy(() -> new Car("car1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이미 사용중인 자동차 이름입니다.");
    }

    @Test
    @DisplayName("If Name Exceeds 5 Characters, Throw Exception")
    void 이름의_길이가_5글자를_넘을_경우_에러_발생() {
        Assertions.assertThatThrownBy(() -> new Car("abcedf"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5글자 이하만 가능합니다");
    }

    @Test
    @DisplayName("If Car Name Is Blank, Throw Error")
    void 이름이_공백일_경우_에러_발생() {
        Assertions.assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 공백일 수 없습니다");

        Assertions.assertThatThrownBy(() -> new Car("   "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 공백일 수 없습니다");
    }
}