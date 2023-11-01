package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.constant.InputError.BLANK_CAR_NAME;
import static racingcar.constant.InputError.EXCEEDED_LIMIT_CAR_LENGTH;
import static racingcar.constant.InputError.EXCEEDED_MAXIMUM_INPUT;
import static racingcar.constant.InputError.NOT_DIGIT_MOVING_COUNT;
import static racingcar.constant.StepConstant.MOVING_FORWARD;
import static racingcar.constant.StepConstant.STOP;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    @Nested
    @DisplayName("자동차 경주를 진행한다.")
    class success_race {

        @DisplayName("경주 결과와 단독 우승자가 출력된다.")
        @Test
        void print_Race_Results_And_Sole_Winner() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("pobi,woni", "1");
                        assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                    },
                    MOVING_FORWARD, STOP
            );
        }

        @DisplayName("경주 결과와 공동 우승자가 출력된다.")
        @Test
        void print_Race_Results_And_Multi_Winner() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("pobi,woni,jun", "3");
                        assertThat(output()).contains("pobi : --", "woni : ", "jun : ", "최종 우승자 : pobi, woni");
                    },
                    MOVING_FORWARD, STOP, STOP, MOVING_FORWARD, MOVING_FORWARD, STOP, STOP, MOVING_FORWARD, STOP
            );
        }
    }

    @Nested
    @DisplayName("자동차 경주를 진행할때 자동차의 이름을 잘못 입력하면 예외가 발생하고 적절한 예외 메세지를 출력한다.")
    class racingCarsInput {

        @DisplayName("자동차 이름의 길이가 제한 길이를 넘기면 안된다.")
        @Test
        void invalid_Name_Input_Exceed_Limit_Length() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(EXCEEDED_LIMIT_CAR_LENGTH.toString())
            );
        }

        @DisplayName("자동차 이름의 공백을 포함하여도 길이 제한을 지켜야한다.")
        @Test
        void invalid_Name_Input_Exceed_Limit_Length_Even_Contain_Blank() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("    po,jin", "1"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(EXCEEDED_LIMIT_CAR_LENGTH.toString())
            );
        }

        @DisplayName("자동차 이름 입력은 필수이다.")
        @Test
        void invalid_Name_Input_Only_Delimiter() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(",,", "1"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(BLANK_CAR_NAME.toString())
            );
        }

        @DisplayName("자동차 이름은 공백일 수 없다.")
        @Test
        void invalid_Name_Input_Blank() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("    ,javi", "1"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(BLANK_CAR_NAME.toString())
            );
        }
    }

    @Nested
    @DisplayName("자동차 경주를 진행할때 이동 횟수를 잘못 입력하면 예외가 발생하고 적절한 예외 메세지를 출력한다.")
    class moving_Count_Input {

        @DisplayName("이동 횟수는 숫자여야한다.")
        @Test
        void invalid_Moving_Count_Input_Not_Digit() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("pobi,java", "1ab3"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(NOT_DIGIT_MOVING_COUNT.toString())
            );
        }

        @DisplayName("이동 횟수는 제한 크기를 넘으면 안된다.")
        @Test
        void invalid_Moving_Count_Input_Too_Big() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("pobi,java", "99999999999"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(EXCEEDED_MAXIMUM_INPUT.toString())
            );
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
