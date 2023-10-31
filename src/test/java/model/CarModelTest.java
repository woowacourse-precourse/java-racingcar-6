package model;

import org.junit.jupiter.api.Test;
import racingcar.model.CarModel;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarModelTest {
    @Test
    void 차_이름_길이가_5_초과인_객체_생성_예외테스트() {
        //given
        String input1 = "abcdef";
        String input2 = "      a";

        //when
        assertThatThrownBy(() -> {
            CarModel carModel1 = new CarModel(input1);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            CarModel carModel2 = new CarModel(input2);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void toString_테스트() {
        //given
        CarModel carModel = new CarModel("car1");
        CarModel carModel2 = new CarModel("car2", 3);
        //when then
        assertThat(carModel.toString()).isEqualTo("car1 : ");
        assertThat(carModel2.toString()).isEqualTo("car2 : ---");
    }
}
