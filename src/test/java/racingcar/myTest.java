package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.control.GameProcess;
import racingcar.domain.Car;
import camp.nextstep.edu.missionutils.test.NsTest;

import java.io.ByteArrayInputStream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

public class myTest {

    @Test
    void 자동차_생성() {
        Car car = new Car("myCar");
        assertThat(car.getMovingDistance()).isEqualTo(0);
        assertThat(car.toString()).isEqualTo("myCar : ");
    }

    @Test
    void 이름_입력이_이상할_경우() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Car("my Car Name is Perfect"));
    }
}
