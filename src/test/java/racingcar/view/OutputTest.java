package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class OutputTest {
    @ParameterizedTest
    @DisplayName("해당 자동차의 전진횟수만큼 '-'를 출력하는지 검증")
    @CsvSource({"'name1', 5, 'name1 : -----'", "'name2', 0, 'name2 : '"})
    void convertProgressToString_test(String carName, int moves, String expected) {
        OutputView sample = new OutputView();
        assertThat(sample.convertProgressToString(carName, moves)).isEqualTo(expected);
    }

    @Test
    @DisplayName("최종 우승자가 1명일 때 실행 결과 예시대로 출력되는지 검증")
    void convertWinnersToString_onlyOne_test() {
        OutputView sample = new OutputView();
        List<String> input = List.of("name1");
        String expected = "최종 우승자 : name1";
        assertThat(sample.convertWinnersToString(input)).isEqualTo(expected);
    }

    @Test
    @DisplayName("최종 우승자가 여러 명일 때 실행 결과 예시대로 출력되는지 검증")
    void convertWinnersToString_manyPeople_test() {
        OutputView sample = new OutputView();
        List<String> input = Arrays.asList("name2", "name3", "name4");
        String expected = "최종 우승자 : name2, name3, name4";
        assertThat(sample.convertWinnersToString(input)).isEqualTo(expected);
    }
}