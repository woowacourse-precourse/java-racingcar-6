package unit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.RacingUtils;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UtilTest {

    private static RacingUtils racingUtils = new RacingUtils();

    @Test
    @DisplayName("문자열을 ,를 기준으로 자른 후 List<String>으로 반환하는 테스트")
    void splitStringToList() {
        String strTest = "sam,tom,bob";
        List<String> strList = racingUtils.splitStringToList(strTest);

        assertThat(strList).contains("sam", "tom", "bob");
    }

    @Test
    @DisplayName("각 이름을 체크하는 메서드 테스트(성공)")
    void isCheckStringLengthMetodSuccess() {
        List<String> strList = List.of("sam", "tom", "bob");
        int len = 3;
        boolean isOver = racingUtils.isCheckStringLength(strList, len);

        assertThat(isOver).isFalse();
    }

    @Test
    @DisplayName("각 이름을 체크하는 메서드 테스트(실패)")
    void isCheckStringLengthMethodFail() {
        List<String> strList = List.of("sam", "tom", "bob");
        int len = 2;
        boolean isOver = racingUtils.isCheckStringLength(strList, len);

        assertThat(isOver).isTrue();
    }

    @Test
    @DisplayName("숫자가 아닌 문자가 들어오거나 숫자가 1보다 작은 경우를 확인하는 메서드 테스트(성공)")
    void isNonNumericAndNegativeMethodSuccess() {
        String num = "5";
        boolean isOk = racingUtils.isNonNumericAndNegative(num);

        assertThat(isOk).isFalse();
    }

    @Test
    @DisplayName("숫자가 아닌 문자가 들어오거나 숫자가 1보다 작은 경우를 확인하는 메서드 테스트(실패 - 숫자가 아닌 경우)")
    void isNonNumericAndNegativeMethodSuccessFailNonNumber() {
        String num = "%";
        boolean isOk = racingUtils.isNonNumericAndNegative(num);

        assertThat(isOk).isTrue();
    }

    @Test
    @DisplayName("숫자가 아닌 문자가 들어오거나 숫자가 1보다 작은 경우를 확인하는 메서드 테스트(실패 - 숫자가 1보다 작은경우)")
    void isNonNumericAndNegativeMethodSuccessFailUnderOne() {
        String num = "0";
        boolean isOk = racingUtils.isNonNumericAndNegative(num);

        assertThat(isOk).isTrue();
    }
}
