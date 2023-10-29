package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    @DisplayName("readNames 함수에서 입력값을 쉼표로 분리해서 출력")
    void readNames함수_쉼표로_분리() {
        try (MockedStatic<Console> mock = Mockito.mockStatic(Console.class)) {
            //given
            mock.when(Console::readLine).thenReturn("pobi,woni,june");
            //when
            String[] result = Application.readNames();
            //then
            assertThat(result).isEqualTo(new String[]{"pobi", "woni", "june"});
        }
    }

    @Test
    @DisplayName("readNames 함수에서 입력 값에 쉼표가 없을 때 그대로 출력")
    void readNames함수_쉼표가_없을_때_그대로_출력() {
        try (MockedStatic<Console> mock = Mockito.mockStatic(Console.class)) {
            //given
            mock.when(Console::readLine).thenReturn("pobi");
            //when
            String[] result = Application.readNames();
            //then
            assertThat(result).isEqualTo(new String[]{"pobi"});
        }
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
