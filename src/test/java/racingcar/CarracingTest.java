package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
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
        Map<String, String> nameList = new LinkedHashMap<>();
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

    private static boolean checkNull(Map<String, String> nameList) {
        for (Map.Entry<String, String> entrySet : nameList.entrySet()) {
            if(entrySet.getValue().equals(null))
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
}