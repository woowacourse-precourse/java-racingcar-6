package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.StringUtils;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * packageName    : racingcar.util
 * fileName       : StringUtilsTest
 * author         : qkrtn_ulqpbq2
 * date           : 2023-10-30
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-10-30        qkrtn_ulqpbq2       최초 생성
 */
public class StringUtilsTest {

    @Test
    @DisplayName("구분자로 문자열 자르기")
    void splitByDelimiterCorrect(){
        String str = "a,b,c,d";
        String delimiter = ",";

        String[] arr = StringUtils.splitByDelimiter(str, delimiter);

        assertThat(arr.length).isEqualTo(4);
    }

    @Test
    @DisplayName("구분자로 문자열 자르기_공백제거")
    void splitByDelimiterInCorrect(){
        String[] arr = {"  test  "};
        String expectStr = "test";

        String[] stripArr = StringUtils.stripStringArray(arr);

        assertThat(stripArr[0]).isEqualTo(expectStr);
    }
}
