package racingcar.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ValidatorTest {

    private final Validator validator = new Validator();

    @Test
    public void 차량_이름_정상_입력_테스트() {
        String input = "a,b,c";
        String[] expectedArray = {"a", "b", "c"};
        String[] resultArray = validator.stringToArray(input);
        assertThat(resultArray).isEqualTo(expectedArray);
    }

    @Test
    public void 차량_이름_띄어쓰기_무시하는지_확인_테스트() {
        String input = "a, b, c";
        String[] expectedArray = {"a", "b", "c"};
        String[] resultArray = validator.stringToArray(input);
        assertThat(resultArray).isEqualTo(expectedArray);
    }

    @Test
    public void 차량_이름_쉼표없는_입력_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.stringToArray("abc"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    public void 차량_이름_5자리_넘어가는_입력_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.stringToArray("a,b,cdefgh"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    public void 차량_이름_중복된_이름_입력_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.stringToArray("a,b,b"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    public void 차량_이름_하나만_입력되는_경우_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.stringToArray("a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    public void 차량_이름_없는_경우_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.stringToArray("a,,c"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    public void 차량_이름_빈칸인_경우_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.stringToArray(""))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    public void 차량_이름_쉼표만_입력되는_경우_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.stringToArray(","))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    public void 시도_횟수_정상_입력_테스트() {
        String input = "5";
        int expectedAttempt = 5;
        int resultAttempt = validator.stringToInt(input);
        assertThat(resultAttempt).isEqualTo(expectedAttempt);
    }

    @Test
    public void 시도_횟수_문자_입력_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.stringToInt("abc"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    public void 시도_횟수_빈칸_입력_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.stringToInt(" "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    public void 시도_횟수_0입력_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.stringToInt("0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    public void 시도_횟수_0이하_입력_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.stringToInt("-10"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}