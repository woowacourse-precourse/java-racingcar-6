package basis;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static constant.ErrorMessage.EMPTY_NAME_CASE_MESSAGE;
import static constant.ErrorMessage.EXCEED_NAME_CASE_MESSAGE;
import static constant.ErrorMessage.NOT_NUMBER_INPUT_CASE_MESSAGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import camp.nextstep.edu.missionutils.test.NsTest;
import racingcar.Application;

class ConverterTest extends NsTest{
    private Converter converter;

    @BeforeEach
    void setup() {
        converter = new Converter();
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void 문자열을_쉼표로_구분해서_해시맵에_넣기() {
        List<String> expected = List.of("pobi", "crong");
        Map<String, String> actualMap = converter.splitAndAddToMap("pobi,crong");
        List<String> actual = new ArrayList<>();
        for (Entry<String, String> entry : actualMap.entrySet()) {
            String s = entry.getKey() + entry.getValue();
            actual.add(s);
        }
        Assertions.assertEquals(expected, actual);
        Assertions.assertThrows(IllegalArgumentException.class, () -> converter.splitAndAddToMap("pobi, ,crong"));
    }

    @Test
    void 문자열을_정수로_반환() {
        Assertions.assertEquals(7, converter.wordToInt("7"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> converter.wordToInt("안녕"));
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
                        .hasMessageContaining(NOT_NUMBER_INPUT_CASE_MESSAGE)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,crong", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(NOT_NUMBER_INPUT_CASE_MESSAGE)
        );
    }
}