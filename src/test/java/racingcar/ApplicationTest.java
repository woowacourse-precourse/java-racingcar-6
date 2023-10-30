package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

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
    @DisplayName("입력 테스트")
    class InputTest {

        @Test
        @DisplayName("자동차 이름이 빈 문자열일 경우 IllegalArgumentException 발생한다.")
        public void 자동차_이름이_빈_문자열일_경우_IllegalArgumentException_발생한다() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("", "1"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        @DisplayName("자동차 이름이 공백일 경우 IllegalArgumentException 발생한다.")
        public void 자동차_이름이_공백일_경우_IllegalArgumentException_발생한다() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("  ", "1"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        @DisplayName("시도 횟수가 문자열일 경우 IllegalArgumentException 발생한다.")
        public void 시도_횟수가_문자열일_경우_IllegalArgumentException_발생한다() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("pobi,woni", "asdf"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        @DisplayName("시도 횟수가 0일 경우 IllegalArgumentException 발생한다.")
        public void 시도_횟수가_0일_경우_IllegalArgumentException_발생한다() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("pobi,woni", "0"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        @DisplayName("시도 횟수가 음수일 경우 IllegalArgumentException 발생한다.")
        public void 시도_횟수가_음수일_경우_IllegalArgumentException_발생한다() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("pobi,woni", "-5"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }
    }

    @Nested
    @DisplayName("이름 테스트")
    class NameTest {
        @Test
        @DisplayName("이름의 길이가 최소 길이 미만일 경우 IllegalArgumentException 발생한다.")
        public void 이름의_길이가_최소_길이_미만일_경우_IllegalArgumentException_발생한다() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("pobi,,woni", "1"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        @DisplayName("이름의 길이가 최대 길이 초과일 경우 IllegalArgumentException 발생한다.")
        public void 이름의_길이가_최대_길이_초과일_경우_IllegalArgumentException_발생한다() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        @DisplayName("자동차 이름이 중복될 경우 IllegalArgumentException 발생한다.")
        public void 자동차_이름이_중복될_경우_IllegalArgumentException_발생한다() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("pobi,pobi", "1"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        @DisplayName("자동차 이름이 비어있을 경우 IllegalArgumentException 발생한다.")
        public void 자동차_이름이_비어있을_경우_IllegalArgumentException_발생한다() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(",", "1"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }
    }

    @Nested
    @DisplayName("출력 테스트")
    class PrintTest {
        private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
        private static final String INPUT_TRY_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";
        private static final String RESULT_MESSAGE = "실행 결과";
        private static final String WINNER_MESSAGE = "최종 우승자 : ";

        @Test
        @DisplayName("안내문구들은 출력되어야 한다.")
        public void 안내문구들은_출력되어야_한다() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("pobi,woni", "1");
                        assertThat(output())
                                .contains(INPUT_CAR_NAMES_MESSAGE, INPUT_TRY_NUMBER_MESSAGE, RESULT_MESSAGE,
                                        WINNER_MESSAGE);
                    },
                    MOVING_FORWARD, STOP
            );
        }

        @Test
        @DisplayName("동점자가 있을 경우 , 로 구분되어 출력되어야 한다.")
        public void 동점자가_있을_경우__로_구분되어_출력되어야_한다() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("pobi,woni", "1");
                        assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
                    },
                    MOVING_FORWARD, MOVING_FORWARD
            );
        }
    }
}
