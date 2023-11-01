package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class CarTest {
    private static final Car car1 = new Car("car");
    private static final Car car2 = new Car("test");

    @Test
    void Car_toString(){
        assertThat(car1.toString()).isEqualTo("car : ");
    }
}
