package racingcar.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class UtilsTest {

    private Utils utils;

    @BeforeEach
    public void setUp() {
        utils = new Utils();
    }

    @DisplayName("사용자가 입력한 문자열을 리스트로 반환한다.")
    @Test
    void convertStringToList() {
        // given
        String names = "pobi,lee,kim";
        List<String> nameList = List.of("pobi","lee","kim");

        // when
        List<String> getNames = utils.convertStringToList(names);

        // then
        IntStream.range(0, nameList.size())
                .forEach(i -> assertThat(getNames.get(i)).isEqualTo(nameList.get(i)));
    }
}