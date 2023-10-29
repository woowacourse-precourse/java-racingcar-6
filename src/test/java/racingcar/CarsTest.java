package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class CarsTest {

    @DisplayName("콤마로 이름을 구분하여 Car 객체를 만드는 테스트")
    @Test
    public void separateNameTest() {
        Cars cars = new Cars("dahee,hui,pobi");
        Car dahee = cars.getCar(0);
        Car hui = cars.getCar(1);
        Car pobi = cars.getCar(2);

        Assertions.assertThat(dahee.getName()).isEqualTo("dahee");
        Assertions.assertThat(hui.getName()).isEqualTo("hui");
        Assertions.assertThat(pobi.getName()).isEqualTo("pobi");
    }
}
