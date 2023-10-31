package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car1;
    private Car car2;
    @BeforeEach
    void setUp() {
        car1 = new Car("robin");
        car2 = new Car("hood");
    }
    @Test
    void 자동차_이름_조회() {
        assertThat(car1.getName()).isEqualTo("robin");
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5})
    void 자동차_전진_횟수_조회(int forwardNum) {
        for(int i = 0; i < forwardNum; i++){
            car1.increaseForwardNum();
        }
        assertThat(car1.getForwardNum()).isEqualTo(forwardNum);
    }

    @Test
    void 자동차_객체_전진_증가_테스트() {
        assertSimpleTest(() -> {
            assertThat(car1.getForwardNum()).isEqualTo(0);
            car1.increaseForwardNum();
            car2.increaseForwardNum();
            assertThat(car2.getForwardNum()).isEqualTo(1);
        });
    }
}
