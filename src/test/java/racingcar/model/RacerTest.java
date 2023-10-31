package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.constant.message.Message;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacerTest {

    @DisplayName("잘못된 참가자 입력 체크")
    @ParameterizedTest(name = "{displayName}: {0}")
    @NullSource
    @ValueSource(strings = {"", ",", ",car", ",,,,,", ",,dk"})
    void checkRacer(String value) {
        assertThatThrownBy(() -> Racer.of(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 이름 체크")
    @ParameterizedTest(name = "{displayName}: {0}")
    @ValueSource(strings = {"ad,k,la,a,la", "l,l", "qwe,kz,pi,pi", "a, a,a ", "ba,l, ba"})
    void checkUnique(String value) {
        assertThatThrownBy(() -> Racer.of(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("올바른 이름 입력 체크")
    @ParameterizedTest(name = "{displayName}: {0}, {1}")
    @ValueSource(strings = {"12,345,675", "212 ,34, 5533", "ad,d dk,i"})
    void checkValidate(String value) {
        Racer racer = Racer.of(value);
        List<String> excepted = Arrays.stream(value.split(Message.NAME_SEPARATOR))
                .map(String::trim)
                .toList();
        assertThat(racer.toString()).contains(excepted);
    }
}