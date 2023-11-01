package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringUtilsTest {

    @DisplayName("generateDashString 메서드 테스트 - Dash 반복 출력")
    @Test
    void should_Repeat_Dash_For_Given_Count() {
        // given
        int count = 7;

        // when
        String dashString = StringUtils.generateDashString(count);

        // then
        assertThat(dashString).isEqualTo("-------");
    }

    @DisplayName("splitStringToList 메서드 테스트 - String을 List<String>으로 변환")
    @Test
    void should_Convert_String_To_List_Of_Strings() {
        // given
        String str = "x,y,z";

        // when
        List<String> list = StringUtils.splitStringToList(str);

        // then
        assertThat(list).containsExactly("x", "y", "z");
    }
}