package racingcar.domain.power;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

@DisplayName("파워 공급기 테스트")
class PowerGeneratorTest {

    @DisplayName("생성된 파워는 0-9사이의 범위를 가져야 한다")
    @RepeatedTest(100)
    void defaultPowerGeneratorRangeTest() {
        PowerGenerator powerGenerator = new DefaultPowerGenerator();
        assertTrue(isNumberInRange(powerGenerator.generate(), 0, 9));
    }

    private boolean isNumberInRange(int number, int min, int max) {
        return (number >= min) && (number <= max);
    }
}