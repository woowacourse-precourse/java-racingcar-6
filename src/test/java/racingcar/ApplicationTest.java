package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

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
    @DisplayName("isValidsting 함수에서 이름 정상으로 입력받은 경우 True 반환")
    void isValidsting함수_이름_정상_입력시_False_반환() {
        //given
        String[] names = new String[]{"pobi", "woni", "june"};
        //when
        boolean result = Application.isValidString(names);
        //then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("isValidsting 함수에서 공백을 입력받은 경우 False 반환")
    void isValidsting함수_전체_공백_입력시_False_반환() {
        //given
        String[] names = new String[]{""};
        //when
        boolean result = Application.isValidString(names);
        //then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("isValidsting 함수에서 이름을 1개만 입력받은 경우 False 반환")
    void isValidsting함수_이름_1개_입력시_False_반환() {
        //given
        String[] names = new String[]{"pobi"};
        //when
        boolean result = Application.isValidString(names);
        //then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("isValidsting 함수에서 입력받은 이름 중 5글자 초과인한 이름이 있는 경우 False 반환")
    void isValidsting함수_이름_5글자_초과_포함시_False_반환() {
        //given
        String[] names = new String[]{"pobi", "woniwoni", "june"};
        //when
        boolean result = Application.isValidString(names);
        //then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("isValidsting 함수에서 입력받은 이름 중 공백이 있는 경우 False 반환")
    void isValidsting함수_입력값_중_이름_공백_있으면_False_반환() {
        //given
        String[] names = new String[]{"pobi", "", "june"};
        //when
        boolean result = Application.isValidString(names);
        //then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("isValidsting 함수에서 중복된 이름 입력받았을 경우 False 반환")
    void isValidsting함수_입력값_중_이름_중복_있으면_False_반환() {
        //given
        String[] names = new String[]{"pobi", "pobi", "june"};
        //when
        boolean result = Application.isValidString(names);
        //then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("readCount 함수에서 입력값 정상 반환되는지 확인")
    void readCount함수_입력값_정상반환_확인() {
        try (MockedStatic<Console> mock = Mockito.mockStatic(Console.class)) {
            //given
            mock.when(Console::readLine).thenReturn("5");
            //when
            int result = Application.readCount();
            //then
            assertThat(result).isEqualTo(5);
        }
    }

    @Test
    @DisplayName("isValidNumber 함수에서 숫자가 아닌 값을 입력받았을 경우 False 반환")
    void isValidNumber함수_입력값_숫자아니면_False_반환() {
        //given
        String count = new String("a");
        //when
        boolean result = Application.isValidNumber(count);
        //then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("isValidNumber 함수에서 공백을 입력받았을 경우 False 반환")
    void isValidNumber함수_입력값_공백이면_False_반환() {
        //given
        String count = new String("");
        //when
        boolean result = Application.isValidNumber(count);
        //then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("isValidNumber 함수에서 1_미만의 값을 입력받았을 경우 False 반환")
    void isValidNumber함수_입력값_1_미만이면_False_반환() {
        //given
        String count = new String("0");
        //when
        boolean result = Application.isValidNumber(count);
        //then
        assertThat(result).isFalse();
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
