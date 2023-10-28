package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class CarGroupTest {

    @Test
    void 자동차_그룹에_이미_등록된_이름을_등록하면_예외_발생() {
        CarGroup carGroup = new CarGroup();
        carGroup.addCar("test");

        assertThatThrownBy(() -> carGroup.addCar("test"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}