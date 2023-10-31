package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    public void Car_인스턴스_생성() {
        String name = "자동차";
        Car car = new Car(name);

        assertThat(car.getClass()).isEqualTo(Car.class);
    }

    @Test
    public void Car_생성_실패() {
        String name = "abcded";
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 전진_성공() {
        Car car = new Car("pobi");
        car.tryMove(4);
        assertThat(car.getNowPlace()).isEqualTo("-");
    }

    @Test
    public void 전진_실패() {
        Car car = new Car("pobi");
        car.tryMove(3);
        assertThat(car.getNowPlace()).isEqualTo("");
    }

    @Test
    public void 입력값에_공백이_포함된_경우_예외_발생() {
        String input = " pobi";
        Car car = new Car(input);
        assertThatThrownBy(() -> car.hasSpace(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력은 공백이 포함될 수 없습니다.");
    }

    @Test
    public void 입력값이_공백인_경우_예외_발생() {
        String input="";
        Car car = new Car(input);
        assertThatThrownBy(() -> car.isEmpty(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력은 공백일 수 없습니다.");
    }

    @Test
    public void 입력값이_5자를_초과하는_경우_예외_발생() {
        String input = "#4abc3";
        Car car = new Car(input);
        assertThatThrownBy(() -> car.isOverLength(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력은 5자 이하여야 합니다.");
    }


}
