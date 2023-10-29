package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarracingTest {
    private Carracing carracing;

    @BeforeEach
    void setUp() {
        carracing = new Carracing();
    }

    @ParameterizedTest
    @MethodSource("provideCarName")
    void 자동차_출발점_위치(String[] names) {
        Map<String, String> nameList = new LinkedHashMap<>();
        nameList = carracing.setInitStartPoint(names);

        String expectedResult = sumScore(nameList);

        assertThat(expectedResult).isEqualTo("");
    }

    private static boolean checkNull(Map<String, String> nameList) {
        for (Map.Entry<String, String> entrySet : nameList.entrySet()) {
            if(entrySet.getValue().equals(null))
                return true;
        }
        return false;
    }

    private static String sumScore(Map<String, String> result) {
        StringBuilder scoreSum = new StringBuilder();
        for (Map.Entry<String, String> entrySet : result.entrySet()) {
            scoreSum.append(entrySet.getValue());
        }

        return scoreSum.toString();
    }

    private static Stream<Arguments> provideCarName() {
        return Stream.of(
                Arguments.of((Object) new String[]{"pobi", "woni", "jun"}),
                Arguments.of((Object) new String[]{"cheon", "hyun", "woo", "pobi", "woni", "jun"}),
                Arguments.of((Object) new String[]{"pobi", "woni"})
        );
    }
}