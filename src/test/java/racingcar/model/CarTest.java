package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    @DisplayName("자동차 이름에 공백이 입력되었을 시 예외 처리")
    public void checkEmptyName() {
        assertThatThrownBy(() -> {
            Car car = new Car("");
        }).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("[ERROR] : 자동차 이름을 입력해주세요.");
    }

    @Test
    @DisplayName("5글자를 초과하는 이름 입력 시 예외 처리")
    public void checkNameLength() {
        assertThatThrownBy(() -> {
            Car car = new Car("kiminsu");
        }).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("[ERROR] : 5글자 이하의 자동차 이름을 입력해주세요");
    }

    @Test
    @DisplayName("이름이 같으면 같은 객체로 인식")
    public void nameEqualityTest(){
        Car pobiCar = new Car("pobi");
        assertThat(pobiCar).isEqualTo(new Car("pobi"));
    }
}