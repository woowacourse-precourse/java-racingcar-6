package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InputConvertUtilsTest {

    public final String DELIMITER = ",";

    @DisplayName("하나의 문자열로 입력된 이름들을 List<String>으로 변환한다. 구분자(,)로 나누고, 양끝 공백을 제거해서 생성")
    @Test
    public void convertInputString() throws Exception {
        //given
        String name1 = "pobi";
        String name2 = "jason";
        String name3 = "hihi";
        String name3WithSpaces = "  hihi";
        String input = name1 + DELIMITER + name2 + DELIMITER + name3WithSpaces;

        //when
        List<String> names = InputConvertUtils.carNamesToList(input);

        //then
        assertThat(names).containsExactly(name1, name2, name3);
     }
}
