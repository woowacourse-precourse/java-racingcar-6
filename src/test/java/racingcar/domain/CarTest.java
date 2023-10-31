package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import testwatcher.ProbabilityWatcher;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class CarTest {
    @DisplayName("forName()을 통해 이름이 5글자 이하인 Car만 생성가능하다")
    @ParameterizedTest
    @CsvSource(value = {"'',true", "a,true", "ab,true", "abc,true", "abcd,true", "abcde,true", "abcdef,false"})
    void forNameTest(String carName, boolean canCreate) {
        if (canCreate) {
            assertInstanceOf(Car.class, Car.from(carName));
        } else {
            assertThrows(IllegalArgumentException.class,
                    () -> Car.from(carName),
                    "Car 이름은 5자 이하여야 합니다.");
        }
    }

    @DisplayName("proceed() 시 position이 1증가한다")
    @Test
    void proceedTest() {
        // given
        Car car = Car.from("name");
        int prevPosition = car.getPosition();

        // when
        car.proceed();
        int afterPosition = car.getPosition();

        assertEquals(prevPosition + 1, afterPosition);
    }

    @DisplayName("stop() 시 position이 변하지 않는다")
    @Test
    void stopTest() {
        // given
        Car car = Car.from("name");
        int prevPosition = car.getPosition();

        // when
        car.stop();
        int afterPosition = car.getPosition();

        assertEquals(prevPosition, afterPosition);
    }

    /**
     * 이 테스트는 이항분포 신뢰구간(Z = 1, 95%구간)을 사용한 통계적 테스트입니다.
     * isProceed()의 반환값이 true일 확률이 60 퍼센트에 가까워야함을 테스트합니다.
     *
     * 현재 케이스는 이항분포이므로, 정규화 계산이 평균과 분산을 보증합니다.
     * 연속값에 대한 검증은 엔트로피 테스트 등의 대안이 있지만, 해당 테스트에 대한 필요성은 의문입니다.
     *
     * 실패하지는 않으나, 신뢰구간을 벗어나면 경고합니다.
     */
    @DisplayName("isProceed()가 true일 확률이 60%에 가깝다")
    @Tag("확률테스트")
    @ExtendWith(ProbabilityWatcher.class)
    @Test
    void isProceedTest(TestInfo testInfo) {
        // given
        Car car = Car.from("name");

        int n = 1000; // 시행횟수
        double p = 0.6; // 확률

        double halfInterval = 1.96 * Math.sqrt(p * (1 - p) / n); // Z = 1

        // when
        int proceedCnt = 0;
        for (int i = 0; i < n; i++) {
            if (car.isProceedNext()) {
                proceedCnt++;
            }
        }

        double X = (double) proceedCnt / n;
        boolean isInConfidenceInterval = (X > p - halfInterval && X < p + halfInterval);

        String report = "독립시행횟수: " + n
                + "\n구간 절반 길이: " + halfInterval
                + "\n신뢰구간: " + (p - halfInterval) + " ~ " + (p + halfInterval)
                + "\n실제 확률: " + X
                + "\n신뢰구간 준수여부: " + isInConfidenceInterval;

        boolean warn = !isInConfidenceInterval;
        ProbabilityWatcher.registerResult(testInfo, report, warn);
    }
}
