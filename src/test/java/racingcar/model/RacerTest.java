package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacerTest {

    @DisplayName("참가자가 없는 경우 체크")
    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {""})
    void checkRacer(String value) {
        assertThatThrownBy(() -> new Racer(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 이름 체크")
    @ParameterizedTest
    @ValueSource(strings = {"ad,k,la,a,la", "l,l", "qwe,kz,pi,pi"})
    void checkUnique(String value) {
        assertThatThrownBy(() -> new Racer(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}