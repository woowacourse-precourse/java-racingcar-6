package racingcar.domain.power;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

@DisplayName("파워 공급기 테스트")
class PowerGeneratorTest {

    private PowerGenerator powerGenerator = new DefaultPowerGenerator();

    @DisplayName("생성된 파워는 0-9사이의 범위를 가져야 한다")
    @RepeatedTest(100)
    void testGeneratedPowerInRange() {
        assertTrue(generatedPowerCannotBeBiggerThanMaxPower());
        assertTrue(generatedPowerisAlwaysBiggerThanMinPower());

    }

    private boolean generatedPowerisAlwaysBiggerThanMinPower() {
        return powerGenerator.generate().isSufficientToDrive(new Power(0));
    }

    private boolean generatedPowerCannotBeBiggerThanMaxPower() {
        return !powerGenerator.generate().isSufficientToDrive(new Power(10));
    }


}