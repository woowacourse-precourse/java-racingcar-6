package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class InputTest extends NsTest {
    public static final String WRONG_CAR_NAME_ERROR_MESSAGE = "자동차 목록은 쉼표로 구분되어야 하고, 비어있지 않은 문자여야 합니다.";
    public static final String WRONG_NAME_SIZE_ERROR_MESSAGE = "자동차 이름은 1자 이상 5자 이하만 가능합니다.";
    public static final String DUPLICATE_CAR_NAME_ERROR_MESSAGE = "자동차 이름은 중복될 수 없습니다.";
    public static final String WRONG_ROUND_NUM_ERROR_MESSAGE = "시도 횟수는 1 이상의 숫자여야 합니다.";

    @Test
    void 이름이_5자_넘어가면_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(WRONG_NAME_SIZE_ERROR_MESSAGE)
        );
    }


    @Test
    void 이름_중간에_공백이_있으면_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("po bi,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(WRONG_CAR_NAME_ERROR_MESSAGE)
        );
    }

    @Test
    void 구분자_이후에_공백이_있으면_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, java", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(WRONG_CAR_NAME_ERROR_MESSAGE)
        );
    }

    @Test
    void 구분자_이전에_공백이_있으면_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi ,java", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(WRONG_CAR_NAME_ERROR_MESSAGE)
        );
    }

    @Test
    void 구분자_양쪽에_공백이_있으면_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi , java", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(WRONG_CAR_NAME_ERROR_MESSAGE)
        );
    }

    @Test
    void 구분자_이후_문자가_없으면_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(WRONG_CAR_NAME_ERROR_MESSAGE)
        );
    }

    @Test
    void 아무_문자도_입력하지_않으면_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(WRONG_CAR_NAME_ERROR_MESSAGE)
        );
    }

    @Test
    void 아무_문자도_입력하지_않으면_예외가_발생한다2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("\n", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(WRONG_CAR_NAME_ERROR_MESSAGE)
        );
    }

    @Test
    void 이름이_중복되면_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(DUPLICATE_CAR_NAME_ERROR_MESSAGE)
        );
    }

    @Test
    void 시도_하려는_횟수가_1보다_작으면_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(WRONG_ROUND_NUM_ERROR_MESSAGE)
        );
    }

    @Test
    void 시도_하려는_횟수가_없으면_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", " "))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(WRONG_ROUND_NUM_ERROR_MESSAGE)
        );
    }

    @Test
    void 시도_하려는_횟수가_없으면_예외가_발생한다2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "\n"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(WRONG_ROUND_NUM_ERROR_MESSAGE)
        );
    }

    @Test
    void 시도_하려는_횟수_입력시_0으로_시작하면_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "01"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(WRONG_ROUND_NUM_ERROR_MESSAGE)
        );
    }

    @Test
    void 시도_하려는_횟수_입력시_0으로_시작하고_공백이_있으면_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", " 01"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(WRONG_ROUND_NUM_ERROR_MESSAGE)
        );
    }

    @Test
    void 시도_하려는_횟수_입력시_0으로_시작하고_공백이_있으면_예외가_발생한다2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "01 "))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(WRONG_ROUND_NUM_ERROR_MESSAGE)
        );
    }

    @Test
    void 시도_하려는_횟수_입력시_0으로_시작하고_공백이_있으면_예외가_발생한다3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", " 01 "))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(WRONG_ROUND_NUM_ERROR_MESSAGE)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
