package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    private final Car sample = new Car();

    @ParameterizedTest
    @DisplayName("쉼표(,) 유무에 관계없이 입력값이 모든 유효성 검사를 통과하면 정상 종료")
    @ValueSource(strings = {"name1", "name1,name2,name3"})
    void createCarNameList_splitTest(String input) {
        assertThatCode(() -> sample.createCarNameList(input))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("모든 유효성 검사를 통과하는 입력값이면 key가 되는 자동차 이름은 Map에 입력 순서대로 저장")
    void createCarNameList_orderTest() {
        String input = "name1,name2,name3,name4";
        Set<String> expected = new LinkedHashSet<>(Arrays.asList(input.split(",")));
        Map<String, Integer> result = sample.createCarNameList(input);
        assertThat(expected).isEqualTo(result.keySet());
    }
}
