package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.util.Validator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }


    @Nested
    class CarTest {
        @Test
        @DisplayName("toString 재정의, 전진 테스트")
        public void toStringTest(){
            Car pobi = new Car("pobi");
            String result = "pobi : --";
            pobi.moveAdvence(5);
            pobi.moveAdvence(5);

            assertThat(pobi.toString()).isEqualTo(result);
        }

        @Test
        @DisplayName("랜덤한 수에 따라 전진해도 되는지 확인")
        public void isOkayToGoForwardTest(){
            Car car = new Car("철수");

            assertThat(car.isOkayToGoForward(6))
                    .isEqualTo(true);
            assertThat(car.isOkayToGoForward(3))
                    .isEqualTo(false);
        }

    }

    @Nested
    class ValidatorTest{

        @Test
        @DisplayName("숫자이외의 문자가 들어오면 예외 테스트")
        void validateNumericInputTest(){
            assertThatThrownBy(()->Validator.validateNumericInput("avb"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("숫자를 입력해");
        }

        @Test
        @DisplayName("입력값이 올바른 형식인지 테스트")
        void validateNamesTest(){
            String carNames = "pobi,woni,jun,dragon,김테스트";
            assertThatThrownBy(()->
                    Validator.validateCarNames(carNames))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("잘못된 값을");

        }


    }






}
