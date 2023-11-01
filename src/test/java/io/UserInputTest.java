package io;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static constant.ErrorMessage.EMPTY_NAME_CASE_MESSAGE;
import static constant.ErrorMessage.EXCEED_NAME_CASE_MESSAGE;
import static constant.ErrorMessage.NOT_POSITIVE_NUMBER_INPUT_CASE_MESSAGE;
import static constant.ErrorMessage.UNCOMPETITIVE_CASE_MESSAGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import base.Converter;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import validation.UserInputValidator;

class UserInputTest extends NsTest {

    @BeforeEach
    void setup() {
        UserInputValidator userInputValidator = new UserInputValidator();
        Converter converter = new Converter(userInputValidator);
        new UserInput(converter);
    }

    @Test
    void 차_이름의_입력길이_기준을_초과했을_때() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(EXCEED_NAME_CASE_MESSAGE)
        );
    }

    @Test
    void 입력된_차_개수가_1개_이하일_때() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(UNCOMPETITIVE_CASE_MESSAGE)
        );
    }

    @Test
    void 차_이름에_공백이름을_입력했을_때() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, ,rong", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(EMPTY_NAME_CASE_MESSAGE)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,   crong", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(EMPTY_NAME_CASE_MESSAGE)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("     pobi,crong", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(EMPTY_NAME_CASE_MESSAGE)
        );
    }

    @Test
    void 시도_횟수를_0_또는_음수로_입력했을_때() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,crong", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(NOT_POSITIVE_NUMBER_INPUT_CASE_MESSAGE)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,crong", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(NOT_POSITIVE_NUMBER_INPUT_CASE_MESSAGE)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}