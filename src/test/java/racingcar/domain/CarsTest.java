package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.Application;

class CarsTest extends NsTest {
    @Nested
    @DisplayName("정상 작동 테스트")
    class NormalTests {
        @Test
        @DisplayName("자동차 입력 테스트1")
        void testParsingInput1() {
            run("car1,car2", "1");
            assertThat(output()).contains("car1", "car2");
        }

        @Test
        @DisplayName("자동차 입력 테스트2")
        void testParsingInput2() {
            run("car1, car2", "1");
            assertThat(output()).contains("car1", "car2");
        }


        @Test
        @DisplayName("자동차 움직이기 테스트")
        void testMoveCars() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("Test1,Test2", "1");
                        assertThat(output()).contains("Test1 : -", "Test2 : ");
                    },
                    4, 3
            );
        }
    }

    @Nested
    @DisplayName("exception 테스트")
    class ExceptionTests {
        @Test
        @DisplayName("자동차 이름 중복 검사")
        void testDuplicateCarNames() {
            assertThatThrownBy(() -> runException("Test,Test", "1"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("자동차 이름은 중복될 수 없음.");
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}