package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.Car.createCarByName;

class CarTest {

    @Test
    void createCarByNameTest() {
        String longName = "abcdef";
        String emptyName = "";
        String name = "abc";
        String nameWithNull = null;

        assertThatThrownBy(() -> createCarByName(longName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5자 이하의 이름만 입력해주세요");

        assertThatThrownBy(() -> createCarByName(emptyName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1자 이상의 이름만 입력해주세요");

        assertThatThrownBy(() -> createCarByName(nameWithNull))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("null은 이름이 될 수 없습니다");
    }

}