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

}