package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("toString 재정의, 전진 테스트")
    public void toStringTest(){
        Car pobi = new Car("pobi");
        String result = "pobi : --";
        pobi.moveForward(5);
        pobi.moveForward(5);

        assertThat(pobi.toString()).isEqualTo(result);
    }

    @Test
    @DisplayName("랜덤한 수에 따라 전진해도 되는지 확인")
    public void isOkayToGoForwardTest(){
        Car car = new Car("철수");

        assertThat(car.isOkayToGoForward(6))
                .isEqualTo(true);
        assertThat(car.isOkayToGoForward(3))
                .isEqualTo(false);
    }





}