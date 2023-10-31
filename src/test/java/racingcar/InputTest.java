package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputTest extends NsTest {

    private static final String ILLEGAL_NAME_SIZE_EXCEPTION_MESSAGE = "자동차 이름은 5자리 이하로 만들어야 합니다";
    private static final String VOID_NAME_EXCEPTION_MESSAGE = "자동차 이름은 공백으로 설정할 수 없습니다.";
    private static final String DUPLICATE_NAME_EXCEPTION_MESSAGE = "자동차 이름이 중복됩니다.";
    private static final String ZERO_ATTEMPT_NUMBER_EXCEPTION_MESSAGE = "시도 횟수는 1이상이어야 합니다.";
    private static final String ILLEGAL_ATTEMPT_NUMBER_EXCEPTION_MESSAGE = "시도 횟수는 숫자여야 합니다.";

    private InputDataHandler inputDataHandler = new InputDataHandler();

    @Test
    void 자동차_이름_자릿수_테스트(){
        assertSimpleTest(()->
            assertThatThrownBy(()->runException("pobi,pobipobi","1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ILLEGAL_NAME_SIZE_EXCEPTION_MESSAGE));
    }

    @Test
    void 자동차_이름_쉼표_구분_테스트(){
        String[] result = inputDataHandler.seperateString("pobi,woni,jun");
        String[] expect = {"pobi","woni","jun"};
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void 자동차_이름_VOID_테스트(){
        assertSimpleTest(()->
            assertThatThrownBy(()->runException("woni,,jun","1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(VOID_NAME_EXCEPTION_MESSAGE));
    }

    @Test
    void 자동차_이름_중복_테스트(){
        assertSimpleTest(()->
            assertThatThrownBy(()->runException("pobi,pobi,jun","1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATE_NAME_EXCEPTION_MESSAGE));
    }

    @Test
    void 시도_횟수_잘못된_입력값_테스트(){
        assertSimpleTest(()->
            assertThatThrownBy(()->runException("pobi,woni,jun","0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ZERO_ATTEMPT_NUMBER_EXCEPTION_MESSAGE));
    }

    @Test
    void 시도_횟수_잘못된_입력형식_테스트(){
        assertSimpleTest(()->
            assertThatThrownBy(()->runException("pobi,woni,jun","six"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ILLEGAL_ATTEMPT_NUMBER_EXCEPTION_MESSAGE));
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
