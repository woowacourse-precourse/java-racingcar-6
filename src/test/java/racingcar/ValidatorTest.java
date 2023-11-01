package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.util.Validator;


class ValidatorTest {
    Validator validator;

    @BeforeEach
    void setUp() {
        validator = new Validator();
    }

    @Test
    void 자동차이름_빈문자_입력에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.checkCarNamesInput(""))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도횟수_빈문자_입력에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.checkNumberOfTrialInput(""))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 자동차이름_1글자미만에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.checkCarNamesInput("a,"))
                        .isInstanceOf(IllegalArgumentException.class));
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.checkCarNamesInput("a,b,,c"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 자동차이름_5글자초과에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.checkCarNamesInput("a,b,javaigi"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 자동차이름_공백에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.checkCarNamesInput("a, ,c"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 자동차이름_중복에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.checkCarNamesInput("a,a"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 시도횟수_문자_입력에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.checkNumberOfTrialInput("a"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 자동차이름_입력이_하나인_경우에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.checkCarNamesInput("a"))
                        .isInstanceOf(IllegalArgumentException.class));
    }
}
