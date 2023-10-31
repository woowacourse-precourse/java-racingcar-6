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
    void 값이_같은_vo는_동등하다() {
        CarName carName1 = new CarName("pobi");
        CarName carName2 = new CarName("pobi");
        Assertions.assertThat(carName1.toString()).isEqualTo(carName2.toString());
        Assertions.assertThat(carName1).isEqualTo(carName2);
    }

    @Test
    void 값이_같은_vo는_동일하다() {
        CarName carName1 = new CarName("pobi");
        CarName carName2 = new CarName("pobi");
        Assertions.assertThat(carName1).hasSameHashCodeAs(carName2);
    }

    @Test
    void 값이_다른_vo는_동등하지않다() {
        CarName carName1 = new CarName("pobi");
        CarName carName2 = new CarName("woni");
        Assertions.assertThat(carName1).isNotEqualTo(carName2);
    }

    @Test
    void 값이_다른_vo는_동일하지않다() {
        CarName carName1 = new CarName("pobi");
        CarName carName2 = new CarName("woni");
        Assertions.assertThat(carName1).doesNotHaveSameHashCodeAs(carName2);
    }

}
