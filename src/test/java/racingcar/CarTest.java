package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.util.validator.InputValidator.checkBlank;
import static racingcar.util.validator.InputValidator.checkComma;
import static racingcar.util.validator.InputValidator.isNegativeNumber;
import static racingcar.util.validator.InputValidator.isNonNumericString;
import static racingcar.util.validator.InputValidator.isStringLengthValid;

import org.junit.jupiter.api.Test;

public class CarTest extends NsTest{
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
    void 우승자가_여려_명일_경우() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,test", "1");
                    assertThat(output()).contains("pobi : -", "woni : -","test : -", "최종 우승자 : pobi, woni, test");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }
    @Test
    void 문자열_앞뒤_쉼표_포함_시_예외_발생() {
        String input = ",abc,test";

        assertThatThrownBy(() -> checkComma(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력받은 값 앞뒤 ','쉼표 포함");
    }

    @Test
    void 분리된_문자열_앞뒤_공백_포함_시_예외_발생() {
        String input = "test ";

        assertThatThrownBy(() -> checkBlank(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("문자열 앞뒤 ' '공백 포함");
    }

    @Test
    void 분리된_문자열_길이가_6_이상인_경우_예외_발생() {
        String input = "123456";

        assertThatThrownBy(() -> isStringLengthValid(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("문자열 길이 6자리 이상");
    }
    @Test
    void 분리된_문자열_길이가_0인_경우_예외_발생() {
        String input = "";

        assertThatThrownBy(() -> isStringLengthValid(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("문자열 길이 0");
    }
    @Test
    void 입력받은_값이_숫자가_아닌_경우_예외_발생() {
        String input = "a";
        assertThatThrownBy(() -> isNonNumericString(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력받은 값이 정수형 숫자가 아님");
    }


    @Test
    void 입력받은_값이_음수_인_경우_예외_발생() {
        int input = -1;
        assertThatThrownBy(() -> isNegativeNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력받은 값이 음수");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
