package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class InputViewTest extends NsTest {

    private final InputView inputView = new InputView();

    @Test
    void validateCarName_이름이_5자_초과인_경우_Exception() {
        //given
        String input = "asdfg,qweroitp,fjeoplkj";
        String[] names = input.split(",");
        //when & then
        assertThatThrownBy(() -> inputView.validateCarName(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하여야 합니다.");
    }

    @Test
    void inputRoundCnt_시도할_횟수가_숫자가_아닌_경우_Exception() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi", "e"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}