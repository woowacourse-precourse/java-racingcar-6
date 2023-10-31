package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputParserTest {

    @Test
    @DisplayName("자동차 이름 입력을 List<String> 객체로 파싱 테스트")
    void carNameParsingToListTest() {
        //given
        String names = "pobi,java,jigi";

        //when
        List<String> nameList = InputParser.parseCarNameList(names);

        //then
        assertThat(nameList).contains("pobi", "java", "jigi");
    }
}
