package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarracingTest {
    private final boolean CAR_LOCATE_START_POINT = false;
    private Carracing carracing;
    private Map<String, String> raceScore;

    void setInstance() {
        carracing = new Carracing();
    }

    void setMapInstance() {
        carracing.raceScore = new HashMap<>();
        carracing.raceScore.put("pobi", "");
        carracing.raceScore.put("woni", "");
    }

    @ParameterizedTest
    @MethodSource("provideCarName")
    void 자동차_출발점_위치(String[] names) {
        setInstance();
        Map<String, String> nameList;
        nameList = carracing.setInitStartPoint(names);

        boolean checkSetInitStartPoint = checkNull(nameList);

        assertThat(checkSetInitStartPoint).isEqualTo(CAR_LOCATE_START_POINT);
    }

    @ParameterizedTest
    @CsvSource({"pobi, 4, pobi, -", "pobi, 3, pobi, ''", "woni, 4, pobi, ''"})
    void 자동차_전진_스탑(String name, int randomNumber, String resultName, String score) {
        setMapInstance();
        carracing.move(name, randomNumber);

        assertThat(carracing.raceScore.get(resultName)).isEqualTo(score);
    }

    @ParameterizedTest
    @MethodSource("provideGameResult")
    void 순위_정렬(Map<String, String> gameResult, List<String> winnerList) {
        List<String> nameList = new ArrayList<>();
        nameList.add("pobi");
        nameList.add("woni");
        nameList.add("jun");

        carracing.raceScore = gameResult;

        carracing.sortRanking(nameList);

        assertThat(nameList).isEqualTo(winnerList);
    }

    private static boolean checkNull(Map<String, String> nameList) {
        //모든 자동차의 value값이 ""로 설정되어있다면 false를 반환
        //자동차의 value값 중 하나라도 ""로 설정되어있지 않다면 true를 반환
        boolean containNullValue = nameList.entrySet().stream()
                .anyMatch(entry -> entry.getValue() == null);

        if(containNullValue) {
            return true;
        }
        return false;
    }

    private static Stream<Arguments> provideCarName() {
        return Stream.of(
                Arguments.of((Object) new String[]{"pobi", "woni", "jun"}),
                Arguments.of((Object) new String[]{"cheon", "hyun", "woo", "pobi", "woni", "jun"}),
                Arguments.of((Object) new String[]{"pobi", "woni"})
        );
    }

    private static Stream<Arguments> provideGameResult() {
        return Stream.of(
                Arguments.of(new LinkedHashMap<String, String>() {{
                    put("pobi", "---");
                    put("woni", "----");
                    put("jun", "-----");
                }}, Arrays.asList("jun", "woni", "pobi")),

                Arguments.of(new LinkedHashMap<String, String>() {{
                    put("pobi", "----");
                    put("woni", "-----");
                    put("jun", "---");
                }}, Arrays.asList("woni", "pobi", "jun")),

                Arguments.of(new LinkedHashMap<String, String>() {{
                    put("pobi", "-----");
                    put("woni", "----");
                    put("jun", "-----");
                }}, Arrays.asList("pobi", "jun", "woni"))

        );
    }
}