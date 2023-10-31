package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RacingTest {

    @ParameterizedTest
    @DisplayName("한 자동차가 얻은 0~9 사이 임의의 정수값이 4 이상이면 해당 자동차의 전진횟수는 1 증가")
    @CsvSource({"5, 4, 6", "5, 3, 5"})
    void progressOrNot_test(int moveInput, int randomNum, int expected) {
        Racing sample = new Racing();
        assertThat(sample.progressOrNot(moveInput, randomNum)).isEqualTo(expected);
    }

    @Test
    @DisplayName("전진횟수가 최대인 자동차만 최종 우승자로 선정")
    void getWinnerList_findMax_test() {
        Racing sample = new Racing();
        Map<String, Integer> input = new LinkedHashMap<>(Map.of(
                "alpha", 5, "gamma", 6,
                "delta", 3, "beta", 6
        ));
        assertThat(sample.getWinnerList(input)).contains("gamma", "beta");
    }

    @Test
    @DisplayName("최종 우승자 명단은 Map에 저장된 순서대로 저장")
    void getWinnerList_orderTest() {
        Racing sample = new Racing();
        Map<String, Integer> input = new LinkedHashMap<>(Map.of(
                "alpha", 5, "gamma", 6,
                "delta", 3, "beta", 6
        ));
        Set<String> expected = new LinkedHashSet<>(List.of("gamma", "beta")); // 삽입된 순서 유지
        Set<String> result = new LinkedHashSet<>(sample.getWinnerList(input));
        assertThat(expected).isEqualTo(result);
    }
}