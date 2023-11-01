package racingcar;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameTest {
    @Test
    void 자동차_이름_중복_테스트(){
        String[] carNameSample = {"k5","k7","k8","k5"};
        assertThatThrownBy(() -> Cars.createCarList(carNameSample))
                .isInstanceOf(IllegalArgumentException.class);
    }
    //String[] carNameSample = {"k5","k7","k8"};
    //Cars.createCarList(carNameSample);

}
