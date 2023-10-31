package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class RandomGasolineProviderTest extends NsTest {

    private static final int MAX_GASOLINE_AMOUNT = 10;

    @Test
    void 올바르게_랜덤_숫자_반환() {
        int expectedResult = getRandomGasoline();
        assertRandomNumberInRangeTest(
                () -> {
                    run();
                    assertThat(output()).contains(String.valueOf(expectedResult));
                },
                expectedResult
        );
    }

    @Override
    protected void runMain() {
        RandomGasolineProvider randomGasolineProvider = new RandomGasolineProvider();
        int result = randomGasolineProvider.provide();
        System.out.println(result);
    }

    private int getRandomGasoline() {
        return (int) (Math.random() * MAX_GASOLINE_AMOUNT);
    }
}