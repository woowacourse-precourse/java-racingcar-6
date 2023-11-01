package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.exception.round.totalNumberOfRounds.NonPositiveIntegerException.NON_POSITIVE_INTEGER_EXCEPTION_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @AfterEach
    void closeConsole() {
        Console.close();
    }

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

    // Custom
    @ParameterizedTest
    @CsvSource(value = {"1,2,:이름은 1자 이상 5자 이하", "1,2,123456:이름은 1자 이상 5자 이하", "na,me,na:중복된 자동차 이름",
            "1,2,\t3:공백이 포함"}, delimiter = ':')
    public void 자동차_이름_입력_예외_테스트(String arg, String errorMessage) {
        final byte[] buf = arg.getBytes();
        InputStream inputStream = new ByteArrayInputStream(buf);
        System.setIn(inputStream);

        assertThatThrownBy(() -> {
            Application.main(new String[]{});
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorMessage);
    }

    @Test
    public void 라운드수_양수가_아닌_경우() {
        List<String[]> argsList = new ArrayList<>() {{
            add(new String[]{"a,b", "0"});
            add(new String[]{"a,b", "-1"});
            add(new String[]{"a,b", "#$"});
            add(new String[]{"a,b", "_12"});
            add(new String[]{"a,b", "001"});
            add(new String[]{"a,b", "하위"});
            add(new String[]{"a,b", "aa"});
        }};

        for (String[] args : argsList) {
            byte[] buf = String.join("\n", args).getBytes();
            InputStream inputStream = new ByteArrayInputStream(buf);
            System.setIn(inputStream);

            assertThatThrownBy(() -> {
                Application.main(new String[]{});
            }).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(NON_POSITIVE_INTEGER_EXCEPTION_MESSAGE);
            Console.close();
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
