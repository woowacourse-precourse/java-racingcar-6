package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @ParameterizedTest
    @ValueSource(ints = {2, 5, 0, 9})
    void 자동차_랜덤_숫자_초기화_및_조회_확인_테스트(int randomNum) {
        assertRandomNumberInRangeTest(
                () -> {
                    car1.initRandomNum();
                    assertThat(car1.getRandomNum()).isEqualTo(randomNum);
                },
                randomNum
        );
    }

    @Test
    @DisplayName("Car의 전진 횟수 증가 함수 동작 테스트")
    void 자동차_객체_전진_증가_테스트() {
        assertSimpleTest(() -> {
            assertThat(car1.getForwardNum()).isEqualTo(0);
            car1.increaseForwardNum();
            car2.increaseForwardNum();
            assertThat(car2.getForwardNum()).isEqualTo(1);
        });
    }
}
