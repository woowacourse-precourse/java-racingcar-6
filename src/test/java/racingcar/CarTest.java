package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.utils.Random;

public class CarTest {
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName("전진 조건을 올바르게 판단하는가?")
    void test(int number) {
        System.out.println(number);
        assertThat(Random.isConditionsAdvancementMet(number)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {5,6,7})
    @DisplayName("전진 조건을 올바르게 판단하는가?")
    void test2(int number) {
        assertThat(Random.isConditionsAdvancementMet(number)).isTrue();
    }
}
