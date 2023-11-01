package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class NameExceptionTest extends NsTest {
    @Test
    void 이름_입력시_5자가_넘는_경우_예외_처리1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("woowacourse,abcdef", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    // To-Do 함수들 타입에 맞춰 순서 정렬
    @Test
    void 이름_입력시_공백_있을_경우_예외_처리1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",,,a,b,c,d", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_입력시_공백_있을_경우_예외_처리2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,,,", "4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_입력시_공백_있을_경우_예외_처리3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",,c,,", "5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_입력시_공백_있을_경우_예외_처리4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",,,,", "5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_입력시_공백_있을_경우_예외_처리5() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",,,,,,,,,,,,,,,", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_입력시_공백_있을_경우_예외_처리6() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_입력시_공백_있을_경우_예외_처리7() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_입력시_알파벳_외_문자_예외_처리1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a1,a,s,d", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_입력시_알파벳_외_문자_예외_처리2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2,3,d", "6"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_입력시_알파벳_외_문자_예외_처리3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("김,최,정", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_입력시_알파벳_외_문자_예외_처리4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a, b,c", "4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_입력시_알파벳_외_문자_예외_처리5() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,b,c ", "2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_입력시_알파벳_외_문자_예외_처리6() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a ,b,c", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_입력시_알파벳_외_문자_예외_처리7() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,김,c", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_입력시_중복_예외_처리1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,a,c", "2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_입력시_중복_예외_처리2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("ab,kim,choi,jeong,ab", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_입력시_자동차_수_예외_처리1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,b,c,d,e,f,g,h,i,j,k", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
