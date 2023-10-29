package racingcar.vo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarNameTest {

    @Test
    void CarName_생성() {
        CarName carName = new CarName("pobi");
        Assertions.assertThat(carName.toString()).isEqualTo("pobi");
    }

    @Test
    void 같은_VO_동등성_검사() {
        CarName carName1 = new CarName("pobi");
        CarName carName2 = new CarName("pobi");
        Assertions.assertThat(carName1.toString()).isEqualTo(carName2.toString());
        Assertions.assertThat(carName1).isEqualTo(carName2);
    }

    @Test
    void 같은_VO_동일성_검사() {
        CarName carName1 = new CarName("pobi");
        CarName carName2 = new CarName("pobi");
        Assertions.assertThat(carName1).hasSameHashCodeAs(carName2);
    }
}
