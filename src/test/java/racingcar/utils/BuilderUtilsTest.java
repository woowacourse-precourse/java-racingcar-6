package racingcar.utils;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class BuilderUtilsTest {

    @Test
    void 빌더를_자동차_개수만큼_생성하고_초기_출력문_설정_검사() {
        List<String> carNames = List.of("car1", "car2", "car3");
        BuilderUtils builderUtils = new BuilderUtils(carNames);
        StringBuilder[] builder;
        builder = new StringBuilder[carNames.size()];

        for (int i = 0; i < carNames.size(); i++) {
            builder[i] = new StringBuilder(carNames.get(i)).append(" : ");
        }

        assertAll(
                () -> {
                    for (int i = 0; i < carNames.size(); i++) {
                        assertEquals(builder[i].toString(), (carNames.get(i) + " : "));
                    }
                },
                () -> assertNotNull(builderUtils),
                () -> assertEquals(builder.length, carNames.size())
        );
    }

    @Test
    void 자동차의_현재_위치_출력_검사() {
        List<String> carNames = List.of("Car1", "Car2", "Car3");
        BuilderUtils builderUtils = new BuilderUtils(carNames);

        for (int i = 0; i < 3; i++) {
            builderUtils.appendToCarPosition(2);
        }
        for (int i = 0; i < 2; i++) {
            builderUtils.appendToCarPosition(1);
        }
        builderUtils.appendToCarPosition(0);

        String[] carPositions = builderUtils.getCarPositions();

        assertEquals("Car1 : -", carPositions[0]);
        assertEquals("Car2 : --", carPositions[1]);
        assertEquals("Car3 : ---", carPositions[2]);
    }
}
